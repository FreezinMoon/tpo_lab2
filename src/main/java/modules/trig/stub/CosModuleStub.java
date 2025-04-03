package main.java.modules.trig.stub;

import main.java.modules.trig.CosModule;

import java.util.HashMap;
import java.util.Map;

public class CosModuleStub implements CosModule {
    private final Map<Double, Double> table = new HashMap<>();

    public CosModuleStub() {
        table.put(0.0, 1.0);
        table.put(Math.PI / 2, 0.0);
        table.put(Math.PI, -1.0);
        table.put(-Math.PI / 2, 0.0);
    }

    @Override
    public double cos(double x) {
        Double val = table.get(x);
        if (val == null) {
            throw new UnsupportedOperationException("CosModuleStub: нет значения для x=" + x);
        }
        return val;
    }
}
