package test.java.unit;

import main.java.modules.trig.real.CosModuleReal;
import main.java.modules.trig.real.SinModuleReal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CosModuleRealTest {

    @Test
    public void testCosBasicValues() {
        SinModuleReal sinReal = new SinModuleReal(1e-4);
        CosModuleReal cosReal = new CosModuleReal(sinReal);

        assertEquals(1.0, cosReal.cos(0.0), 1e-5);

        assertEquals(0.0, cosReal.cos(Math.PI / 2), 1e-5);

        assertEquals(-1.0, cosReal.cos(Math.PI), 1e-5);
    }
}
