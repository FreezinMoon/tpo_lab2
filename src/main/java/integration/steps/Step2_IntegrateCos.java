package main.java.integration.steps;

import main.java.modules.log.stub.LnModuleStub;
import main.java.modules.log.stub.Log2ModuleStub;
import main.java.modules.log.stub.Log3ModuleStub;
import main.java.modules.log.stub.Log5ModuleStub;
import main.java.modules.trig.CosModule;
import main.java.modules.trig.SinModule;
import main.java.modules.trig.real.CosModuleReal;
import main.java.modules.trig.real.SinModuleReal;
import main.java.modules.trig.stub.CotModuleStub;
import main.java.modules.trig.stub.SecModuleStub;
import main.java.modules.trig.stub.TanModuleStub;
import main.java.system.PiecewiseFunction;

public class Step2_IntegrateCos {

    public static PiecewiseFunction createSystem() {
        SinModule sinReal = new SinModuleReal(1e-7);
        CosModule cosReal = new CosModuleReal(sinReal);

        // Всё остальное stub:
        TanModuleStub tanStub = new TanModuleStub();
        CotModuleStub cotStub = new CotModuleStub();
        SecModuleStub secStub = new SecModuleStub();

        Log2ModuleStub log2Stub = new Log2ModuleStub();
        Log3ModuleStub log3Stub = new Log3ModuleStub();
        Log5ModuleStub log5Stub = new Log5ModuleStub();
        LnModuleStub lnStub = new LnModuleStub();

        return new PiecewiseFunction(tanStub, cotStub, secStub, log2Stub, log3Stub, log5Stub, lnStub);
    }
}
