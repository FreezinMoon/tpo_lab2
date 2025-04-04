package main.java.integration.steps;

import main.java.modules.log.stub.LnModuleStub;
import main.java.modules.log.stub.Log2ModuleStub;
import main.java.modules.log.stub.Log3ModuleStub;
import main.java.modules.log.stub.Log5ModuleStub;
import main.java.modules.trig.CosModule;
import main.java.modules.trig.SecModule;
import main.java.modules.trig.SinModule;
import main.java.modules.trig.TanModule;
import main.java.modules.trig.real.CosModuleReal;
import main.java.modules.trig.real.SecModuleReal;
import main.java.modules.trig.real.SinModuleReal;
import main.java.modules.trig.real.TanModuleReal;
import main.java.modules.trig.stub.CotModuleStub;
import main.java.system.PiecewiseFunction;

public class Step2_IntegrateTan {

    public static PiecewiseFunction createSystem() {
        SinModule sinReal = new SinModuleReal(1e-5);
        CosModule cosReal = new CosModuleReal(sinReal);
        SecModule secReal = new SecModuleReal(cosReal);
        TanModule tanReal = new TanModuleReal(sinReal, cosReal);

        CotModuleStub cotStub = new CotModuleStub();

        Log2ModuleStub log2Stub = new Log2ModuleStub();
        Log3ModuleStub log3Stub = new Log3ModuleStub();
        Log5ModuleStub log5Stub = new Log5ModuleStub();
        LnModuleStub lnStub = new LnModuleStub();

        return new PiecewiseFunction(tanReal, cotStub, secReal, log2Stub, log3Stub, log5Stub, lnStub);
    }
}
