package chap30_enum정의.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * [java 문법]
 *
 * enum은 추상메서드를 가질 수 있어, enum 상수마다 다르게 일을 할 수 있다.
 * 이걸로 if문과 같이 분기문을 매끄럽게 표현할 수 있다.
 * 마치 enum 자료형은 인터페이스, 추상클래스와 같은 일을 할 수 있다는 것이다.
 */
public enum Operation {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    // 형인자 자료형 추측은 자바7 부터 생김.
    private static final Map<String, Operation> stringToEnum = new HashMap<>();

    // 모든 static 필드가 초기화된 후 시작되는 게 static 이란 영역
    static {
        System.out.println(String.format("Operation static 영역, map: %s", stringToEnum));
        for(Operation operation: values()){
            stringToEnum.put(operation.toString(), operation);
        }
    }

    Operation(String symbol) {
        this.symbol = symbol;
        System.out.println("Operation call constructor: " + this);

        // enum에선 static 멤버를 생성자에서 접근할 수 없다..
        // 왜냐하면 클래스가 만들어질 때 순서대로 static 변수인 PLUS, MINUS, TIMES, DIVIDE가 만들어지는데
        // stringToEnum은 이들보다 뒤에 선언되어 있어 이 시점에 아직 null인 상태이다.

        // stringToEnum.put(symbol, this);
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static Operation fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    abstract public double apply(double x, double y);
}
