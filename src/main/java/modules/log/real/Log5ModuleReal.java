package main.java.modules.log.real;

import main.java.modules.log.LnModule;
import main.java.modules.log.Log5Module;

public class Log5ModuleReal implements Log5Module {

    private final LnModule lnModule;
    private final double ln5;

    public Log5ModuleReal(LnModule lnModule) {
        this.lnModule = lnModule;
        this.ln5 = lnModule.ln(5.0);
        if (Math.abs(this.ln5) < 1e-15) {
            throw new ArithmeticException("ln(5)≈0 - невозможная ситуация");
        }
    }

    @Override
    public double log5(double x) {
        double lnX = lnModule.ln(x);
        return lnX / ln5;
    }
}
