package test.java.integration;

import main.java.integration.steps.FinalStep_AllReal;
import main.java.system.PiecewiseFunction;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class FinalAllRealTest {

    @Test
    public void testNegativeXFullReal() {
        PiecewiseFunction sys = FinalStep_AllReal.createSystem();
        double x = -0.5;
        double val = sys.calculate(x);
        System.out.println("FULL REAL: f(-0.5) = " + val);
        assertFalse(Double.isNaN(val));
    }

    @Test
    public void testPositiveXBetweenZeroAndOne() {
        PiecewiseFunction sys = FinalStep_AllReal.createSystem();
        double x = 0.5;
        double val = sys.calculate(x);
        System.out.println("FULL REAL: f(0.5) = " + val);
        assertFalse(Double.isNaN(val));
    }

    @Test(expected = ArithmeticException.class)
    public void testXEqualsOneThrows() {
        PiecewiseFunction sys = FinalStep_AllReal.createSystem();
        sys.calculate(1.0);
    }

    @Test
    public void testXGreaterThanOne() {
        PiecewiseFunction sys = FinalStep_AllReal.createSystem();
        double x = 2.0;
        double val = sys.calculate(x);
        System.out.println("FULL REAL: f(2.0) = " + val);
        assertFalse(Double.isNaN(val));
    }
}