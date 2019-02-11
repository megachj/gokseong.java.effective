package chap34_enum과interface.enums;

import chap34_enum과interface.interfaces.Operation;

public enum BasicOperation implements Operation {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return super.apply(x, y);
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return super.apply(x, y);
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return super.apply(x, y);
        }
    };

    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public double apply(double x, double y) {
        return 3.14;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
