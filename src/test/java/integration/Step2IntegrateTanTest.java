package test.java.integration;

import main.java.integration.steps.Step2_IntegrateTan;
import main.java.system.PiecewiseFunction;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class Step2IntegrateTanTest {

    @Test
    public void testNegativeXNowTanIsReal() {
        PiecewiseFunction sys = Step2_IntegrateTan.createSystem();
        double x = -Math.PI / 4;
        double val = sys.calculate(x);
        System.out.println("Step3 -> f(-pi/4) = " + val);
        assertFalse(Double.isNaN(val));
    }
}
