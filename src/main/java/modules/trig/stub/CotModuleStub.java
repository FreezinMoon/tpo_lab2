package main.java.modules.trig.stub;

import main.java.modules.trig.CotModule;

import java.util.HashMap;
import java.util.Map;

public class CotModuleStub implements CotModule {

    private final Map<Double, Double> table = new HashMap<>();

    public CotModuleStub() {
        table.put(-1., -0.6420926159343306);
        table.put(Math.PI / 4, 1.0);
        table.put(-Math.PI / 4, -1.0);
        table.put(Math.PI / 2, 0.0);
    }

    @Override
    public double cot(double x) {
        Double val = table.get(x);
        if (val != null) return val;
        throw new UnsupportedOperationException("CotModuleStub: нет x=" + x);
    }
}
