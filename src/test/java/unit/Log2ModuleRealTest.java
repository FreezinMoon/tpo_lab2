package test.java.unit;

import main.java.modules.log.LnModule;
import main.java.modules.log.real.LnModuleReal;
import main.java.modules.log.real.Log2ModuleReal;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Log2ModuleRealTest {
    private Log2ModuleReal log2;

    @Before
    public void setUp(){
        LnModule ln = new LnModuleReal(1e-7);
        log2 = new Log2ModuleReal(ln);
    }

    @Test(expected = ArithmeticException.class)
    public void testLog2NegativeThrows() {
        log2.log2(-1.0);
    }

    @Test
    public void testLog2Of1() {
        assertEquals(0.0, log2.log2(1.0), 1e-9);
    }

    @Test
    public void testLog2Of2() {
        double actual = log2.log2(2.0);
        assertEquals(1.0, actual, 1e-5);
    }

    @Test
    public void testLog2Arbitrary() {
        double x = 10.0;
        double actual = log2.log2(x);
        double expected = Math.log(10.0) / Math.log(2.0);
        assertEquals(expected, actual, 1e-5);
    }
}
