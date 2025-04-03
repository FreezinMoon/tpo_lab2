package main.java.modules.log.real;

import main.java.modules.log.LnModule;

public class LnModuleReal implements LnModule {

    private final double eps;

    public LnModuleReal(double eps) {
        this.eps = eps;
    }

    @Override
    public double ln(double x) {
        if (x <= 0.0) {
            throw new ArithmeticException("ln(x) не определён при x <= 0");
        }
        if (x == 1.0) {
            return 0.0;
        }
        if (x > 1.0) {
            return -ln(1.0 / x);
        }

        double y = x - 1.0;
        double sum = 0.0;
        double term = y;
        int n = 1;

        while (Math.abs(term) >= eps) {
            sum += term;
            n++;
            term = Math.pow(y, n) / n;
            if (n % 2 == 0) {
                term = -term;
            }
            if (n > 5000) break;
        }
        return sum;
    }
}
