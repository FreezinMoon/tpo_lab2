package test.java.integration;

import main.java.integration.steps.Step0_AllStubs;
import main.java.system.PiecewiseFunction;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Step0AllStubsTest {

    private PiecewiseFunction sys;

    @Before
    public void setUp() {
        sys = Step0_AllStubs.createAllStubSystem();
    }

    @Test
    public void testNegativeXStub() {
        double x = -Math.PI / 4;

        double result = sys.calculate(x);

        System.out.println("Step0 -> f(-pi/4) = " + result);
        assertFalse(Double.isNaN(result));
    }

    @Test(expected = ArithmeticException.class)
    public void testXEqualsOneThrows() {
        sys.calculate(1.0);
    }

    @Test
    public void testXGreaterThanOneStub() {
        double x = 2.0;
        double val = sys.calculate(x);
        System.out.println("Step0 -> f(2.0) = " + val);
        assertFalse(Double.isNaN(val));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testXEqualsZeroThrows() {
        sys.calculate(0.0);
    }
}
