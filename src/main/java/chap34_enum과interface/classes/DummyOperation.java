package chap34_enum과interface.classes;

import chap34_enum과interface.interfaces.Operation;

public class DummyOperation implements Operation {
    @Override
    public double apply(double x, double y) {
        return -222;
    }
}
