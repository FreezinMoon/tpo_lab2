package test.java.integration;

import main.java.integration.steps.Step1_IntegrateSin;
import main.java.system.PiecewiseFunction;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class Step1IntegrateSinTest {

    @Test
    public void testNegativeXWithRealSin() {
        PiecewiseFunction sys = Step1_IntegrateSin.createSystem();

        double x = -Math.PI / 4;
        double val = sys.calculate(x);
        System.out.println("Step1 -> f(-pi/4) = " + val);
        assertFalse(Double.isNaN(val));
    }

    @Test(expected = ArithmeticException.class)
    public void testXEqualsOneThrowsStill() {
        PiecewiseFunction sys = Step1_IntegrateSin.createSystem();
        sys.calculate(1.0);
    }
}
