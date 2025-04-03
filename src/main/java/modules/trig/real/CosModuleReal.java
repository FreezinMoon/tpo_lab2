package main.java.modules.trig.real;

import main.java.modules.trig.CosModule;
import main.java.modules.trig.SinModule;

public class CosModuleReal implements CosModule {

    private final SinModule sinModule;

    public CosModuleReal(SinModule sinModule) {
        this.sinModule = sinModule;
    }

    @Override
    public double cos(double x) {
        return sinModule.sin(x + Math.PI / 2);
    }
}
