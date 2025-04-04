package main.java.integration.steps;

import main.java.modules.log.real.LnModuleReal;
import main.java.modules.log.stub.Log2ModuleStub;
import main.java.modules.log.stub.Log3ModuleStub;
import main.java.modules.log.stub.Log5ModuleStub;
import main.java.modules.trig.*;
import main.java.modules.trig.real.*;
import main.java.system.PiecewiseFunction;

public class Step4_IntegrateLn {

    public static PiecewiseFunction createSystem() {
        double eps = 1e-5;
        LnModuleReal lnReal = new LnModuleReal(eps);

        Log2ModuleStub log2Stub = new Log2ModuleStub();
        Log3ModuleStub log3Stub = new Log3ModuleStub();
        Log5ModuleStub log5Stub = new Log5ModuleStub();

        SinModule sinReal = new SinModuleReal(eps);
        CosModule cosReal = new CosModuleReal(sinReal);
        SecModule secReal = new SecModuleReal(cosReal);
        TanModule tanReal = new TanModuleReal(sinReal, cosReal);
        CotModule cotReal = new CotModuleReal(tanReal);

        return new PiecewiseFunction(tanReal, cotReal, secReal, log2Stub, log3Stub, log5Stub, lnReal);
    }
}
