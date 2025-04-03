package main.java.modules.log.stub;

import main.java.modules.log.Log2Module;

import java.util.HashMap;
import java.util.Map;

public class Log2ModuleStub implements Log2Module {

    private final Map<Double, Double> table = new HashMap<>();

    public Log2ModuleStub() {
        table.put(1.0, 0.0);
        table.put(2.0, 1.0);
        table.put(4.0, 2.0);
    }

    @Override
    public double log2(double x) {
        Double val = table.get(x);
        if (val == null) {
            throw new UnsupportedOperationException("Log2ModuleStub: нет значения для x=" + x);
        }
        return val;
    }
}
