package test.java.unit;

import main.java.modules.log.real.LnModuleReal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LnModuleRealTest {

    @Test(expected = ArithmeticException.class)
    public void testLnNegativeThrows() {
        LnModuleReal lnReal = new LnModuleReal(1e-7);
        lnReal.ln(-1.0);
    }

    @Test
    public void testLnOne() {
        LnModuleReal lnReal = new LnModuleReal(1e-7);
        assertEquals(0.0, lnReal.ln(1.0), 1e-9);
    }

    @Test
    public void testLnHalf() {
        LnModuleReal lnReal = new LnModuleReal(1e-7);
        double actual = lnReal.ln(0.5);
        assertEquals(Math.log(0.5), actual, 1e-5);
    }

    @Test
    public void testLnE() {
        LnModuleReal lnReal = new LnModuleReal(1e-7);
        double actual = lnReal.ln(Math.E);
        assertEquals(1.0, actual, 1e-5);
    }

    @Test
    public void testLnLarge() {
        LnModuleReal lnReal = new LnModuleReal(1e-7);
        double x = 100.0;
        double actual = lnReal.ln(x);
        assertEquals(Math.log(100.0), actual, 1e-4);
    }
}
