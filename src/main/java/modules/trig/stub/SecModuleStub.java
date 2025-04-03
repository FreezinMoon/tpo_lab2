package main.java.modules.trig.stub;

import main.java.modules.trig.SecModule;

import java.util.HashMap;
import java.util.Map;

public class SecModuleStub implements SecModule {

    private final Map<Double, Double> table = new HashMap<>();

    public SecModuleStub() {
        table.put(0., 1.0);
        table.put(-1., 1.8508157176809255);
        table.put(-0.7853981633974483, 1.414213562373095);
        table.put(Math.PI / 3, 2.);
        table.put(Math.PI, -1.0);
        table.put(Math.PI * 2., 1.0);
    }

    @Override
    public double sec(double x) {
        Double val = table.get(x);
        if (val != null) return val;
        throw new UnsupportedOperationException("SecModuleStub: нет x=" + x);
    }
}
