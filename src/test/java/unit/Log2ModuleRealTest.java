package test.java.unit;

import main.java.modules.log.LnModule;
import main.java.modules.log.real.LnModuleReal;
import main.java.modules.log.real.Log2ModuleReal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Log2ModuleRealTest {

    @Test(expected = ArithmeticException.class)
    public void testLog2NegativeThrows() {
        LnModule ln = new LnModuleReal(1e-7);
        Log2ModuleReal log2 = new Log2ModuleReal(ln);
        log2.log2(-1.0);
    }

    @Test
    public void testLog2Of1() {
        LnModule ln = new LnModuleReal(1e-7);
        Log2ModuleReal log2 = new Log2ModuleReal(ln);
        assertEquals(0.0, log2.log2(1.0), 1e-9);
    }

    @Test
    public void testLog2Of2() {
        LnModule ln = new LnModuleReal(1e-7);
        Log2ModuleReal log2 = new Log2ModuleReal(ln);
        double actual = log2.log2(2.0);
        assertEquals(1.0, actual, 1e-5);
    }

    @Test
    public void testLog2Arbitrary() {
        LnModule ln = new LnModuleReal(1e-7);
        Log2ModuleReal log2 = new Log2ModuleReal(ln);
        double x = 10.0;
        double actual = log2.log2(x);
        double expected = Math.log(10.0) / Math.log(2.0);
        assertEquals(expected, actual, 1e-5);
    }
}
