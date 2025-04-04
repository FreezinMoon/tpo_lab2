package test.java.integration;

import main.java.modules.log.LnModule;
import main.java.modules.log.Log2Module;
import main.java.modules.log.Log3Module;
import main.java.modules.log.Log5Module;
import main.java.modules.trig.*;
import main.java.modules.trig.real.*;
import main.java.system.PiecewiseFunction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class Step3SecTanCotTest {

    private LnModule lnMock;
    private Log2Module log2Mock;
    private Log3Module log3Mock;
    private Log5Module log5Mock;

    private PiecewiseFunction systemUnderTest;

    @Before
    public void setUp() {
        SinModule sinReal = new SinModuleReal(1e-3);
        CosModule cosReal = new CosModuleReal(sinReal);
        TanModule tanReal = new TanModuleReal(sinReal, cosReal);
        SecModule secReal = new SecModuleReal(cosReal);
        CotModule cotReal = new CotModuleReal(tanReal);

        lnMock = mock(LnModule.class);
        log2Mock = mock(Log2Module.class);
        log3Mock = mock(Log3Module.class);
        log5Mock = mock(Log5Module.class);

        systemUnderTest = new PiecewiseFunction(tanReal, cotReal, secReal, log2Mock, log3Mock, log5Mock, lnMock);
    }

    @Test
    public void testNegativeXAllTrigReal() {
        double x = -Math.PI / 3;
        double result = systemUnderTest.calculate(x);
        System.out.println("Step3SecTanCot -> f(" + x + ") = " + result);

        verifyNoInteractions(lnMock, log2Mock, log3Mock, log5Mock);

        assertFalse(Double.isNaN(result));
    }

    @Test
    public void testPositiveXMocksLog() {
        double x = 1.2;
        when(log2Mock.log2(x)).thenReturn(0.263);
        when(log3Mock.log3(x)).thenReturn(0.1);
        when(log5Mock.log5(x)).thenReturn(0.05);
        when(lnMock.ln(x)).thenReturn(0.182);

        double result = systemUnderTest.calculate(x);
        System.out.println("Step3SecTanCot -> f(" + x + ") = " + result);

        assertFalse(Double.isNaN(result));
    }
}
