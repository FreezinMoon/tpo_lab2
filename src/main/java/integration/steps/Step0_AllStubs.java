package main.java.integration.steps;

import main.java.modules.trig.stub.TanModuleStub;
import main.java.modules.trig.stub.CotModuleStub;
import main.java.modules.trig.stub.SecModuleStub;

import main.java.modules.log.stub.LnModuleStub;
import main.java.modules.log.stub.Log2ModuleStub;
import main.java.modules.log.stub.Log3ModuleStub;
import main.java.modules.log.stub.Log5ModuleStub;

import main.java.system.PiecewiseFunction;

public class Step0_AllStubs {

    public static PiecewiseFunction createAllStubSystem() {
        return new PiecewiseFunction(
                new TanModuleStub(),
                new CotModuleStub(),
                new SecModuleStub(),
                new Log2ModuleStub(),
                new Log3ModuleStub(),
                new Log5ModuleStub(),
                new LnModuleStub()
        );
    }
}
