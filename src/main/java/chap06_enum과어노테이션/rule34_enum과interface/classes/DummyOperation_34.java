package chap06_enum과어노테이션.rule34_enum과interface.classes;

import chap06_enum과어노테이션.rule34_enum과interface.interfaces.Operation_34;

public class DummyOperation_34 implements Operation_34 {
    @Override
    public double apply(double x, double y) {
        return -222;
    }
}
