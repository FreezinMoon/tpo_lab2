package main.java.modules.log.stub;

import main.java.modules.log.Log3Module;

import java.util.HashMap;
import java.util.Map;

public class Log3ModuleStub implements Log3Module {

    private final Map<Double, Double> table = new HashMap<>();

    public Log3ModuleStub() {
        table.put(1.0, 0.0);
        table.put(2.0, 0.6309297536);
        table.put(3.0, 1.0);
        table.put(9.0, 2.0);
    }

    @Override
    public double log3(double x) {
        Double val = table.get(x);
        if (val == null) {
            throw new UnsupportedOperationException("Log3ModuleStub: нет значения для x=" + x);
        }
        return val;
    }
}
