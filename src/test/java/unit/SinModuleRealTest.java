package test.java.unit;

import main.java.modules.trig.real.SinModuleReal;
import org.junit.Test;
import static org.junit.Assert.*;

public class SinModuleRealTest {

    @Test
    public void testSinZero() {
        SinModuleReal sinReal = new SinModuleReal(1e-7);
        assertEquals(0.0, sinReal.sin(0.0), 1e-9);
    }

    @Test
    public void testSinPiDiv2() {
        SinModuleReal sinReal = new SinModuleReal(1e-7);
        assertEquals(1.0, sinReal.sin(Math.PI/2), 1e-5);
    }

    @Test
    public void testSinNegativeValue() {
        SinModuleReal sinReal = new SinModuleReal(1e-7);
        assertEquals(-1.0, sinReal.sin(-Math.PI/2), 1e-5);
    }

    @Test
    public void testBigValue() {
        SinModuleReal sinReal = new SinModuleReal(1e-3);
        double actual = sinReal.sin(5.4);
        assertEquals(Math.sin(5.4), actual, 1e-4);
    }
}
