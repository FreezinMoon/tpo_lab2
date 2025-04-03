package test.java.unit;

import main.java.modules.trig.real.CosModuleReal;
import main.java.modules.trig.real.SinModuleReal;
import main.java.modules.trig.real.TanModuleReal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TanModuleRealTest {

    @Test
    public void testTanPi4() {
        SinModuleReal sinReal = new SinModuleReal(1e-7);
        CosModuleReal cosReal = new CosModuleReal(sinReal);
        TanModuleReal tanReal = new TanModuleReal(sinReal, cosReal);

        double val = tanReal.tan(Math.PI / 4); // ~ 1.0
        assertEquals(1.0, val, 1e-5);
    }

    @Test(expected = ArithmeticException.class)
    public void testTanPi2Singularity() {
        SinModuleReal sinReal = new SinModuleReal(1e-7);
        CosModuleReal cosReal = new CosModuleReal(sinReal);
        TanModuleReal tanReal = new TanModuleReal(sinReal, cosReal);

        tanReal.tan(Math.PI / 2);
    }
}
