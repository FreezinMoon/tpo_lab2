package main.java.modules.log.stub;

import main.java.modules.log.LnModule;

import java.util.HashMap;
import java.util.Map;

public class LnModuleStub implements LnModule {

    private final Map<Double, Double> table = new HashMap<>();

    public LnModuleStub() {
        table.put(1.0, 0.0);
        table.put(Math.E, 1.0);
        table.put(0.5, -0.69314718);
        table.put(2.0, 0.69314718);
    }

    @Override
    public double ln(double x) {
        if (x <= 0) {
            throw new ArithmeticException("ln(x): x <= 0 не допустимо.");
        }
        Double val = table.get(x);
        if (val != null) {
            return val;
        }
        throw new UnsupportedOperationException("LnModuleStub: нет значения для x = " + x);
    }
}
