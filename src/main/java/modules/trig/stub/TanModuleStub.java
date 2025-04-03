package main.java.modules.trig.stub;

import main.java.modules.trig.TanModule;

import java.util.HashMap;
import java.util.Map;

public class TanModuleStub implements TanModule {
    private final Map<Double, Double> table = new HashMap<>();

    public TanModuleStub() {
        table.put(0.0, 0.0);
        table.put(-1., -1.5574077246549023);
        table.put(1., 1.5574077246549023);
        table.put(Math.PI / 4, 1.0);
        table.put(-Math.PI / 4, -1.0);
    }

    @Override
    public double tan(double x) {
        Double val = table.get(x);
        if (val != null) {
            return val;
        }
        throw new UnsupportedOperationException(
                "TanModuleStub: нет значения для x=" + x
        );
    }
}
