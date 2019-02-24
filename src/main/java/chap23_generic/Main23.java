package chap23_generic;

import java.util.*;

public class Main23 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        unsafeAdd(strings, new Integer(42));
//        safeAdd(strings, new Integer(45));

//        String s = strings.get(0);

        Set<String> s1 = new HashSet<>(Arrays.asList(new String[]{"aaa", "bbb", "ccc"}));
        Set<String> s2 = new HashSet<>(Arrays.asList(new String[]{"aaa", "bbb"}));

        instanceofFunc(s2);

        int number = numElementsInCommon(s1, s2);
        int number2 = numElementsInCommonWithUnbounded(s1, s2);
        System.out.println(number);
        System.out.println(number2);

        System.out.println(s1.size());

        // 무인자 자료형에서 넣은 숫자때문에 ClassCastException이 발생
        for(String word: s1) {
            System.out.println(word);
        }
    }

    // 무인자 자료형 경우는 컴파일 시점에, 타입 체크를 하지 않는다.
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    // Object인 경우는 컴파일 시점에, 타입 체크를 한다. List<String>과 List<Object>는 다른 타입이다.
    private static void safeAdd(List<Object> list, Object o) {
        list.add(o);
    }

    // 무인자 자료형, 안전하지 않음
    private static int numElementsInCommon(Set s1, Set s2) {
        int result = 0;
        for(Object o1: s1)
            if (s2.contains(o1))
                result++;

        // 무인자 자료형은 아무 자료형이나 넣을 수 있다. 즉 안정성이 없다.
        s1.add(2);

        return result;
    }

    // 비한정적 와일드카드 자료형, 형 안정성과 유연성 만족
    private static int numElementsInCommonWithUnbounded(Set<?> s1, Set<?> s2) {
        int result = 0;
        for(Object o1: s1)
            if (s2.contains(o1))
                result++;

        // 비한정 와일드카드 자료형은 null 이외의 값은 넣을 수 없다.
        //s1.add(2); // 컴파일에러
        s1.add(null);

        return result;
    }

    private static void instanceofFunc(Set<?> s2) {
        // instanceof 연산자에는 형인자를 사용할 수 없다.
        //if(s2 instanceof Set<String>) System.out.println("s2 is Set<String>");

        // 비한정 와일드카드나 무인자나 instanceof 에서 동일하게 동작하므로, 깔끔하게 무인자 자료형을 사용하도록 하자.
        //if(s2 instanceof Set<?>) System.out.println("s2 is Set");
        if(s2 instanceof Set) System.out.println("s2 is Set");

        if(s2 instanceof Set) {
            Set<?> m2 = s2;
        }
    }
}
