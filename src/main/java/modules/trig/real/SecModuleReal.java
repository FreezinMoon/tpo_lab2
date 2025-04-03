package main.java.modules.trig.real;

import main.java.modules.trig.CosModule;
import main.java.modules.trig.SecModule;

public class SecModuleReal implements SecModule {
    private final CosModule cosModule;

    public SecModuleReal(CosModule cosModule) {
        this.cosModule = cosModule;
    }

    @Override
    public double sec(double x) {
        double c = cosModule.cos(x);
        if (Math.abs(c) < 1e-15) {
            throw new ArithmeticException("sec(x) не определён при cos(x)=0");
        }
        return 1.0 / c;
    }
}
