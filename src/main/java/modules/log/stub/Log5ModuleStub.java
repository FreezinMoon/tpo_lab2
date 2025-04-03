package main.java.modules.log.stub;

import main.java.modules.log.Log5Module;

import java.util.HashMap;
import java.util.Map;

public class Log5ModuleStub implements Log5Module {

    private final Map<Double, Double> table = new HashMap<>();

    public Log5ModuleStub() {
        table.put(1.0, 0.0);
        table.put(2.0, 0.4306765581);
        table.put(5.0, 1.0);
        table.put(25.0, 2.0);
    }

    @Override
    public double log5(double x) {
        Double val = table.get(x);
        if (val == null) {
            throw new UnsupportedOperationException("Log5ModuleStub: нет значения для x=" + x);
        }
        return val;
    }
}
