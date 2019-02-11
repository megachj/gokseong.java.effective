package chap34_enum과interface.enums;

import chap34_enum과interface.interfaces.Operation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ExtendedOperation implements Operation {
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
