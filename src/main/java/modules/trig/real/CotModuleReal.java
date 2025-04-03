package main.java.modules.trig.real;

import main.java.modules.trig.CotModule;
import main.java.modules.trig.TanModule;

public class CotModuleReal implements CotModule {
    private final TanModule tanModule;

    public CotModuleReal(TanModule tanModule) {
        this.tanModule = tanModule;
    }

    @Override
    public double cot(double x) {
        double t = tanModule.tan(x);
        if (Math.abs(t) < 1e-15) {
            throw new ArithmeticException("cot(x) не определён при tan(x)=0");
        }
        return 1.0 / t;
    }
}
