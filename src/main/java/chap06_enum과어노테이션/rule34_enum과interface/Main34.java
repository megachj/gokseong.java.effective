package chap06_enum과어노테이션.rule34_enum과interface;

import chap06_enum과어노테이션.rule34_enum과interface.classes.DummyOperation_34;
import chap06_enum과어노테이션.rule34_enum과interface.enums.BasicOperation_34;
import chap06_enum과어노테이션.rule34_enum과interface.enums.ExtendedOperation_34;
import chap06_enum과어노테이션.rule34_enum과interface.interfaces.Operation_34;

import java.util.Arrays;
import java.util.Collection;

public class Main34 {
    public static void main(String[] args) {
        double a = BasicOperation_34.PLUS.apply(10, 20);
        double b = BasicOperation_34.MINUS.apply(10, 20);
        System.out.println(String.format("a: %.2f, b: %.2f", a, b));

        double x = 5, y = 3;
        test(ExtendedOperation_34.class, x, y);
        test2(Arrays.asList(ExtendedOperation_34.values()), x, y);
        test3(ExtendedOperation_34.class, x, y);

        // T 자료형은 Enum이고(&), 그 안의 자료형은 Operation
        // test(DummyOperation.class, x, y);
        test3(DummyOperation_34.class, x, y);
    }

    private static <T extends Enum<T> & Operation_34> void test(Class<T> opSet, double x, double y) {
        for(Operation_34 op: opSet.getEnumConstants()) {
            System.out.println(String.format("%f %s %f = %f%n", x, op, y, op.apply(x,y)));
        }
    }

    private static void test2(Collection<? extends Operation_34> opSet, double x, double y) {
        for(Operation_34 op: opSet) {
            System.out.println(String.format("%f %s %f = %f%n", x, op, y, op.apply(x,y)));
        }
    }

    private static void test3(Class<? extends Operation_34> opSet, double x, double y) {
        for(Operation_34 op: opSet.getEnumConstants()) {
            System.out.println(String.format("%f %s %f = %f%n", x, op, y, op.apply(x,y)));
        }
    }

//    private static <T extends Operation & Enum<T>> void test4(Class<T> opSet, double x, double y) {
//        for(Operation op: opSet.getEnumConstants()) {
//            System.out.println(String.format("%f %s %f = %f%n", x, op, y, op.apply(x,y)));
//        }
//    }
}
