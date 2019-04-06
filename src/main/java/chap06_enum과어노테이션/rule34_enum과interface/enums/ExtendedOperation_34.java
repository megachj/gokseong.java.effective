package chap06_enum과어노테이션.rule34_enum과interface.enums;

import chap06_enum과어노테이션.rule34_enum과interface.interfaces.Operation_34;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ExtendedOperation_34 implements Operation_34 {
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    @Override
    public String toString() {
        return symbol;
    }
}
