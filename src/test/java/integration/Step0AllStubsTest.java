package test.java.integration;

import main.java.integration.steps.Step0_AllStubs;
import main.java.system.PiecewiseFunction;

import org.junit.Test;
import static org.junit.Assert.*;

public class Step0AllStubsTest {

    @Test
    public void testNegativeXStub() {
        PiecewiseFunction sys = Step0_AllStubs.createAllStubSystem();
        double x = -Math.PI / 4;

        double result = sys.calculate(x);

        System.out.println("Step0 -> f(-pi/4) = " + result);
        assertFalse(Double.isNaN(result));
    }

    @Test(expected = ArithmeticException.class)
    public void testXEqualsOneThrows() {
        PiecewiseFunction sys = Step0_AllStubs.createAllStubSystem();
        sys.calculate(1.0); // ждем ArithmeticException
    }

    @Test
    public void testXGreaterThanOneStub() {
        PiecewiseFunction sys = Step0_AllStubs.createAllStubSystem();
        double x = 2.0;
        double val = sys.calculate(x);
        System.out.println("Step0 -> f(2.0) = " + val);
        assertFalse(Double.isNaN(val));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testXEqualsZeroThrows() {
        PiecewiseFunction sys = Step0_AllStubs.createAllStubSystem();
        sys.calculate(0.0);
    }
}
