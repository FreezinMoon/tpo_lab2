package test.java.integration;

import main.java.integration.steps.Step3_IntegrateCot;
import main.java.system.PiecewiseFunction;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class Step3IntegrateCotTest {

    @Test
    public void testNegativeXWithRealCot() {
        PiecewiseFunction sys = Step3_IntegrateCot.createSystem();

        double x = -Math.PI / 4;
        double val = sys.calculate(x);
        System.out.println("Step1 -> f(-pi/4) = " + val);
        assertFalse(Double.isNaN(val));
    }

    @Test(expected = ArithmeticException.class)
    public void testXEqualsOneThrowsStill() {
        PiecewiseFunction sys = Step3_IntegrateCot.createSystem();
        sys.calculate(1.0);
    }
}
