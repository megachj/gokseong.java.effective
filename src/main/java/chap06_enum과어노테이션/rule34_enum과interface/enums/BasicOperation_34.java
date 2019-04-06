package chap06_enum과어노테이션.rule34_enum과interface.enums;

import chap06_enum과어노테이션.rule34_enum과interface.interfaces.Operation_34;

public enum BasicOperation_34 implements Operation_34 {
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

    BasicOperation_34(String symbol) {
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
