package main.java.modules.log.real;

import main.java.modules.log.LnModule;
import main.java.modules.log.Log3Module;

public class Log3ModuleReal implements Log3Module {

    private final LnModule lnModule;
    private final double ln3;

    public Log3ModuleReal(LnModule lnModule) {
        this.lnModule = lnModule;
        this.ln3 = lnModule.ln(3.0);
        if (Math.abs(this.ln3) < 1e-15) {
            throw new ArithmeticException("ln(3)≈0 - невозможная ситуация");
        }
    }

    @Override
    public double log3(double x) {
        double lnX = lnModule.ln(x);
        return lnX / ln3;
    }
}
