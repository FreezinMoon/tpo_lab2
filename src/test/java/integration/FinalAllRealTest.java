package test.java.integration;

import main.java.modules.log.LnModule;
import main.java.modules.log.Log2Module;
import main.java.modules.log.Log3Module;
import main.java.modules.log.Log5Module;
import main.java.modules.log.real.LnModuleReal;
import main.java.modules.log.real.Log2ModuleReal;
import main.java.modules.log.real.Log3ModuleReal;
import main.java.modules.log.real.Log5ModuleReal;
import main.java.modules.trig.*;
import main.java.modules.trig.real.*;
import main.java.system.PiecewiseFunction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FinalAllRealTest {

    private static final double EPS = 1e-3;
    private PiecewiseFunction sys;

    @Before
    public void setUp() {
        double eps = 1e-5;
        SinModule sinReal = new SinModuleReal(eps);
        CosModule cosReal = new CosModuleReal(sinReal);
        TanModule tanReal = new TanModuleReal(sinReal, cosReal);
        CotModule cotReal = new CotModuleReal(tanReal);
        SecModule secReal = new SecModuleReal(cosReal);

        LnModule lnReal = new LnModuleReal(eps);
        Log2Module log2Real = new Log2ModuleReal(lnReal);
        Log3Module log3Real = new Log3ModuleReal(lnReal);
        Log5Module log5Real = new Log5ModuleReal(lnReal);

        sys = new PiecewiseFunction(tanReal, cotReal, secReal, log2Real, log3Real, log5Real, lnReal);
    }

    @Test
    public void testNegativeXFullReal() {
        double x = -0.5;
        double val = sys.calculate(x);
        System.out.println("FULL REAL: f(-0.5) = " + val);
        assertFalse(Double.isNaN(val));
    }

    @Test
    public void testPositiveXBetweenZeroAndOne() {
        double x = 0.5;
        double val = sys.calculate(x);
        System.out.println("FULL REAL: f(0.5) = " + val);
        assertFalse(Double.isNaN(val));
    }

    @Test(expected = ArithmeticException.class)
    public void testXEqualsOneThrows() {
        sys.calculate(1.0);
    }

    @Test
    public void testXGreaterThanOne() {
        double x = 2.0;
        double val = sys.calculate(x);
        System.out.println("FULL REAL: f(2.0) = " + val);
        assertFalse(Double.isNaN(val));
    }

    @Test
    public void testValueAtNegativePiDiv4() {
        double x = -Math.PI / 4;
        double expected = -3.4142135623730945;
        double actual = sys.calculate(x);
        System.out.printf("f(%.5f) = %.10f (ожидалось %.10f)%n", x, actual, expected);
        assertEquals(expected, actual, EPS);
    }

    @Test
    public void testValueAtPositivePoint1() {
        double x = 0.1;
        double expected = 5.9383226588580119221;
        double actual = sys.calculate(x);
        System.out.printf("f(%.5f) = %.10f (ожидалось %.10f)%n", x, actual, expected);
        assertEquals(expected, actual, EPS);
    }

    @Test
    public void testValueAtPositivePoint5() {
        double x = 0.5;
        double expected = 1.4776168645860937615464;
        double actual = sys.calculate(x);
        System.out.printf("f(%.5f) = %.10f (ожидалось %.10f)%n", x, actual, expected);
        assertEquals(expected, actual, EPS);
    }

    @Test
    public void testValueAtPositive2() {
        double x = 2.0;
        double expected = 0.21575735744317888734735;
        double actual = sys.calculate(x);
        System.out.printf("f(%.5f) = %.10f (ожидалось %.10f)%n", x, actual, expected);
        assertEquals(expected, actual, EPS);
    }
}
