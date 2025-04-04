package test.java.integration;

import main.java.modules.log.LnModule;
import main.java.modules.log.Log2Module;
import main.java.modules.log.Log3Module;
import main.java.modules.log.Log5Module;
import main.java.modules.log.real.LnModuleReal;
import main.java.modules.trig.*;
import main.java.modules.trig.real.*;
import main.java.system.PiecewiseFunction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class Step4PlusLnTest {

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
        LnModule lnReal = new LnModuleReal(1e-3);

        log2Mock = mock(Log2Module.class);
        log3Mock = mock(Log3Module.class);
        log5Mock = mock(Log5Module.class);

        systemUnderTest = new PiecewiseFunction(tanReal, cotReal, secReal, log2Mock, log3Mock, log5Mock, lnReal);
    }

    @Test
    public void testNegativeXTrigReal() {
        double x = -1.0;
        double result = systemUnderTest.calculate(x);
        System.out.println("Step4PlusLn -> f(" + x + ") = " + result);
        assertFalse(Double.isNaN(result));

        verifyNoInteractions(log2Mock, log3Mock, log5Mock);
    }

    @Test
    public void testPositiveXMockLogs() {
        double x = 2.0;

        when(log2Mock.log2(x)).thenReturn(1.0);
        when(log3Mock.log3(x)).thenReturn(0.63);
        when(log5Mock.log5(x)).thenReturn(0.43);

        double result = systemUnderTest.calculate(x);
        System.out.println("Step4PlusLn -> f(2.0) = " + result);

        assertFalse(Double.isNaN(result));
    }
}
