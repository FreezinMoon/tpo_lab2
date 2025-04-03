package main.java.system;

import main.java.modules.log.LnModule;
import main.java.modules.log.Log2Module;
import main.java.modules.log.Log3Module;
import main.java.modules.log.Log5Module;
import main.java.modules.trig.CotModule;
import main.java.modules.trig.SecModule;
import main.java.modules.trig.TanModule;


public class PiecewiseFunction {

    private final TanModule tanModule;
    private final CotModule cotModule;
    private final SecModule secModule;

    private final Log2Module log2Module;
    private final Log3Module log3Module;
    private final Log5Module log5Module;
    private final LnModule lnModule;

    public PiecewiseFunction(TanModule tanModule, CotModule cotModule, SecModule secModule, Log2Module log2Module, Log3Module log3Module, Log5Module log5Module, LnModule lnModule) {
        this.tanModule = tanModule;
        this.cotModule = cotModule;
        this.secModule = secModule;
        this.log2Module = log2Module;
        this.log3Module = log3Module;
        this.log5Module = log5Module;
        this.lnModule = lnModule;
    }

    public double calculate(double x) {
        if (x <= 0) {
            return trigPart(x);
        } else {
            return logPart(x);
        }
    }

    private double trigPart(double x) {
        double tanVal = tanModule.tan(x);
        double cotVal = cotModule.cot(x);
        double secVal = secModule.sec(x);

        return ((tanVal + cotVal) - (cotVal - tanVal)) - secVal;
    }

    private double logPart(double x) {
        if (x <= 0) {
            throw new ArithmeticException("logPart недопустим при x <= 0");
        }

        double log5a = log5Module.log5(x);
        double log5b = log5Module.log5(x);
        double lnVal = lnModule.ln(x);

        double numerator = (log5a + log5b) - lnVal;
        double denominator = (log2Module.log2(x) - lnVal);
        if (Math.abs(denominator) < 1e-15) {
            throw new ArithmeticException("Знаменатель log2(x) - ln(x) близок к 0 => функция не определена");
        }

        double fraction = numerator / denominator;
        double leftTerm = fraction - log3Module.log3(x);

        double rightTerm = log5Module.log5(x) * lnVal;

        return leftTerm + rightTerm;
    }
}
