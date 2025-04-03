package test.java.integration;

import main.java.integration.steps.Step4_IntegrateLn;
import main.java.system.PiecewiseFunction;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class Step4IntegrateLnTest {

    @Test
    public void testLogPartWithRealLn() {
        PiecewiseFunction sys = Step4_IntegrateLn.createSystem();

        double x = 2.0;
        double val = sys.calculate(x);
        System.out.println("Step4 -> f(2.0) with real ln = " + val);
        assertFalse(Double.isNaN(val));
    }

    @Test(expected = ArithmeticException.class)
    public void test4EqualsOneStillThrows() {
        PiecewiseFunction sys = Step4_IntegrateLn.createSystem();
        sys.calculate(1.0);
    }
}
