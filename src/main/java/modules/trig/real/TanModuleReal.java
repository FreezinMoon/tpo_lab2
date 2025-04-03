package main.java.modules.trig.real;

import main.java.modules.trig.CosModule;
import main.java.modules.trig.SinModule;
import main.java.modules.trig.TanModule;

public class TanModuleReal implements TanModule {

    private final SinModule sinModule;
    private final CosModule cosModule;

    public TanModuleReal(SinModule sinModule, CosModule cosModule) {
        this.sinModule = sinModule;
        this.cosModule = cosModule;
    }

    @Override
    public double tan(double x) {
        double cosVal = cosModule.cos(x);
        if (Math.abs(cosVal) < 1e-9) {
            throw new ArithmeticException("tan(x) не определён при cos(x) ≈ 0");
        }
        return sinModule.sin(x) / cosVal;
    }

}
