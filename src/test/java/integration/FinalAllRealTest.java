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
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class FinalAllRealTest {

    private static final double EPS = 1e-3;
    @Parameterized.Parameter(0)
    public double x;
    @Parameterized.Parameter(1)
    public double expected;
    private PiecewiseFunction sys;

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{-Math.PI / 4, -3.4142135623730945}, {0.1, 5.9383226588580119221}, {0.5, 1.4776168645860937615464}, {2.0, 0.21575735744317888734735}});
    }

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
    public void testValueAt() {
        double actual = sys.calculate(x);
        System.out.printf("f(%.5f) = %.10f (ожидалось %.10f)%n", x, actual, expected);
        assertEquals(expected, actual, EPS);
    }
}
