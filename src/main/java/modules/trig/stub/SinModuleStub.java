package main.java.modules.trig.stub;

import main.java.modules.trig.SinModule;

import java.util.HashMap;
import java.util.Map;

public class SinModuleStub implements SinModule {

    private final Map<Double, Double> table = new HashMap<>();

    public SinModuleStub() {
        table.put(0.0, 0.0);
        table.put(Math.PI / 6, 0.5);
        table.put(Math.PI / 2, 1.0);
        table.put(Math.PI, 0.0);
        table.put(-Math.PI / 2, -1.0);
    }

    @Override
    public double sin(double x) {
        Double val = table.get(x);
        if (val != null) {
            return val;
        }
        throw new UnsupportedOperationException("SinModuleStub: нет значения для x = " + x);
    }
}
