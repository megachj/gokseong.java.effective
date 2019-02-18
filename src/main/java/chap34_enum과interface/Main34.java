package chap34_enum과interface;

import chap33_EnumMap.classes.Herb;
import chap34_enum과interface.classes.DummyOperation;
import chap34_enum과interface.enums.BasicOperation;
import chap34_enum과interface.enums.ExtendedOperation;
import chap34_enum과interface.interfaces.Operation;

import java.util.Arrays;
import java.util.Collection;

public class Main34 {
    public static void main(String[] args) {
        double a = BasicOperation.PLUS.apply(10, 20);
        double b = BasicOperation.MINUS.apply(10, 20);
        System.out.println(String.format("a: %.2f, b: %.2f", a, b));

        double x = 5, y = 3;
        test(ExtendedOperation.class, x, y);
        test2(Arrays.asList(ExtendedOperation.values()), x, y);
        test3(ExtendedOperation.class, x, y);

        // T 자료형은 Enum이고(&), 그 안의 자료형은 Operation
        // test(DummyOperation.class, x, y);
        test3(DummyOperation.class, x, y);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
        for(Operation op: opSet.getEnumConstants()) {
            System.out.println(String.format("%f %s %f = %f%n", x, op, y, op.apply(x,y)));
        }
    }

    private static void test2(Collection<? extends Operation> opSet, double x, double y) {
        for(Operation op: opSet) {
            System.out.println(String.format("%f %s %f = %f%n", x, op, y, op.apply(x,y)));
        }
    }

    private static void test3(Class<? extends Operation> opSet, double x, double y) {
        for(Operation op: opSet.getEnumConstants()) {
            System.out.println(String.format("%f %s %f = %f%n", x, op, y, op.apply(x,y)));
        }
    }

//    private static <T extends Operation & Enum<T>> void test4(Class<T> opSet, double x, double y) {
//        for(Operation op: opSet.getEnumConstants()) {
//            System.out.println(String.format("%f %s %f = %f%n", x, op, y, op.apply(x,y)));
//        }
//    }
}
