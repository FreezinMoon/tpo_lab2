package main.java.integration.steps;

import main.java.modules.log.real.LnModuleReal;
import main.java.modules.log.stub.Log2ModuleStub;
import main.java.modules.log.stub.Log3ModuleStub;
import main.java.modules.log.stub.Log5ModuleStub;
import main.java.modules.trig.stub.CotModuleStub;
import main.java.modules.trig.stub.SecModuleStub;
import main.java.modules.trig.stub.TanModuleStub;
import main.java.system.PiecewiseFunction;

public class Step4_IntegrateLn {

    public static PiecewiseFunction createSystem() {
        double eps = 1e-7;
        LnModuleReal lnReal = new LnModuleReal(eps);

        Log2ModuleStub log2Stub = new Log2ModuleStub();
        Log3ModuleStub log3Stub = new Log3ModuleStub();
        Log5ModuleStub log5Stub = new Log5ModuleStub();

        TanModuleStub tanStub = new TanModuleStub();
        CotModuleStub cotStub = new CotModuleStub();
        SecModuleStub secStub = new SecModuleStub();

        return new PiecewiseFunction(tanStub, cotStub, secStub, log2Stub, log3Stub, log5Stub, lnReal
        );
    }
}
