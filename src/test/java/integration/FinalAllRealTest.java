package test.java.integration;

import main.java.integration.steps.FinalStep_AllReal;
import main.java.system.PiecewiseFunction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FinalAllRealTest {

    private static final double EPS = 1e-3;
    private PiecewiseFunction sys;

    @Before
    public void setUp() {
        sys = FinalStep_AllReal.createSystem();
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
