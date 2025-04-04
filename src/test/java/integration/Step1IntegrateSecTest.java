package test.java.integration;

import main.java.integration.steps.Step1_IntegrateSec;
import main.java.system.PiecewiseFunction;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class Step1IntegrateSecTest {

    @Test
    public void testSomeNegativeX() {
        PiecewiseFunction sys = Step1_IntegrateSec.createSystem();
        double x = -1.0;
        double val = sys.calculate(x);
        System.out.println("Step2 -> f(-1.0) = " + val);
        assertFalse(Double.isNaN(val));
    }
}
