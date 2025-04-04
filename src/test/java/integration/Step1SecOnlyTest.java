package test.java.integration;

import main.java.modules.log.LnModule;
import main.java.modules.log.Log2Module;
import main.java.modules.log.Log3Module;
import main.java.modules.log.Log5Module;
import main.java.modules.trig.CotModule;
import main.java.modules.trig.SecModule;
import main.java.modules.trig.TanModule;
import main.java.modules.trig.real.CosModuleReal;
import main.java.modules.trig.real.SecModuleReal;
import main.java.modules.trig.real.SinModuleReal;
import main.java.system.PiecewiseFunction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class Step1SecOnlyTest {

    private TanModule tanMock;
    private CotModule cotMock;

    private Log2Module log2Mock;
    private Log3Module log3Mock;
    private Log5Module log5Mock;
    private LnModule lnMock;

    private PiecewiseFunction systemUnderTest;

    @Before
    public void setUp() {
        SecModule secReal = new SecModuleReal(new CosModuleReal(new SinModuleReal(1e-3)));

        tanMock = mock(TanModule.class);
        cotMock = mock(CotModule.class);

        log2Mock = mock(Log2Module.class);
        log3Mock = mock(Log3Module.class);
        log5Mock = mock(Log5Module.class);
        lnMock = mock(LnModule.class);

        systemUnderTest = new PiecewiseFunction(tanMock, cotMock, secReal, log2Mock, log3Mock, log5Mock, lnMock);
    }

    @Test
    public void testNegativeX() {
        when(tanMock.tan(-0.5)).thenReturn(1.2);
        when(cotMock.cot(-0.5)).thenReturn(0.8);

        double result = systemUnderTest.calculate(-0.5);
        System.out.println("Step1SecOnly -> f(-0.5) = " + result);

        verifyNoInteractions(log2Mock, log3Mock, log5Mock, lnMock);

        assertFalse(Double.isNaN(result));
    }

    @Test(expected = ArithmeticException.class)
    public void testPositiveXTriggersLogPartException() {
        when(log2Mock.log2(1.0)).thenReturn(0.0);
        when(lnMock.ln(1.0)).thenReturn(0.0);

        systemUnderTest.calculate(1.0);
    }
}
