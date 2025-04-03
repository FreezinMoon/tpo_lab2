package main.java.modules.log.real;

import main.java.modules.log.LnModule;
import main.java.modules.log.Log2Module;

public class Log2ModuleReal implements Log2Module {

    private final LnModule lnModule;
    private final double ln2;

    public Log2ModuleReal(LnModule lnModule) {
        this.lnModule = lnModule;
        this.ln2 = lnModule.ln(2.0);
        if (Math.abs(this.ln2) < 1e-15) {
            throw new ArithmeticException("ln(2)≈0 - невозможная ситуация");
        }
    }

    @Override
    public double log2(double x) {
        double lnX = lnModule.ln(x);
        return lnX / ln2;
    }
}
