package test.java.integration;

import main.java.integration.steps.Step2_IntegrateCos;
import main.java.system.PiecewiseFunction;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class Step2IntegrateCosTest {

    @Test
    public void testSomeNegativeX() {
        PiecewiseFunction sys = Step2_IntegrateCos.createSystem();
        double x = -1.0;
        double val = sys.calculate(x);
        System.out.println("Step2 -> f(-1.0) = " + val);
        assertFalse(Double.isNaN(val));
    }
}
