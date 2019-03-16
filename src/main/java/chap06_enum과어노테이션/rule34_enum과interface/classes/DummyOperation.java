package chap06_enum과어노테이션.rule34_enum과interface.classes;

import chap06_enum과어노테이션.rule34_enum과interface.interfaces.Operation;

public class DummyOperation implements Operation {
    @Override
    public double apply(double x, double y) {
        return -222;
    }
}
