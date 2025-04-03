package main.java.modules.trig.real;

import main.java.modules.trig.SinModule;

public class SinModuleReal implements SinModule {

    private final double eps;

    public SinModuleReal(double eps) {
        this.eps = eps;
    }

    @Override
    public double sin(double x) {
        double term = x;
        double sum = x;
        int k = 1;

        while (Math.abs(term) >= eps) {
            double power = Math.pow(x, 2 * k + 1);
            long fact = factorial(2 * k + 1);
            term = ((k % 2 == 0) ? 1.0 : -1.0) * power / fact;
            sum += term;
            k++;
            if (k > 30) {
                break;
            };
//            System.out.println("power: " + power + "\nfact: " + fact + "\nterm: " + term + "\nsum: " + sum + "\nk: " + k + '\n');
        }
        return sum;
    }

    private long factorial(int n) {
        long f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }
}
