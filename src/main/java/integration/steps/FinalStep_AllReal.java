package main.java.integration.steps;

import main.java.modules.log.LnModule;
import main.java.modules.log.Log2Module;
import main.java.modules.log.Log3Module;
import main.java.modules.log.Log5Module;
import main.java.modules.log.real.LnModuleReal;
import main.java.modules.log.real.Log2ModuleReal;
import main.java.modules.log.real.Log3ModuleReal;
import main.java.modules.log.real.Log5ModuleReal;
import main.java.modules.trig.*;
import main.java.modules.trig.real.*;
import main.java.system.PiecewiseFunction;

public class FinalStep_AllReal {
    public static PiecewiseFunction createSystem() {
        double eps = 1e-7;
        SinModule sinReal = new SinModuleReal(eps);
        CosModule cosReal = new CosModuleReal(sinReal);
        TanModule tanReal = new TanModuleReal(sinReal, cosReal);
        CotModule cotReal = new CotModuleReal(tanReal);
        SecModule secReal = new SecModuleReal(cosReal);

        LnModule lnReal = new LnModuleReal(eps);
        Log2Module log2Real = new Log2ModuleReal(lnReal);
        Log3Module log3Real = new Log3ModuleReal(lnReal);
        Log5Module log5Real = new Log5ModuleReal(lnReal);

        return new PiecewiseFunction(tanReal, cotReal, secReal, log2Real, log3Real, log5Real, lnReal);
    }
}
