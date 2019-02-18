package chap23_generic;

import java.util.ArrayList;
import java.util.List;

public class Main23 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        unsafeAdd(strings, new Integer(42));
        // safeAdd(strings, new Integer(45));

        String s = strings.get(0);
    }

    // 무인자 자료형 경우는 컴파일 시점에, 타입 체크를 하지 않는다.
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    // Object인 경우는 컴파일 시점에, 타입 체크를 한다. List<String>과 List<Object>는 다른 타입이다.
    private static void safeAdd(List<Object> list, Object o) {
        list.add(o);
    }

}
