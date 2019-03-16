package chap05_제네릭.rule27_제네릭메서드;

import chap05_제네릭.rule27_제네릭메서드.interfaces.UnaryFunction;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main27 {
    // 제네릭 싱글턴 팩터리 패턴, 익명 객체 버전
    private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
        @Override
        public Object apply(Object arg) {
            return arg;
        }
    };

    // 제네릭 싱글턴 팩터리 패턴, 람다 버전
    private static UnaryFunction<Object> IDENTITY_FUNCTION_LAMBDA = arg -> arg;

    public static void main(String[] args) {
        Set<String> guys = new HashSet<>(Arrays.asList(new String[]{"Tom", "Dick", "Harry"}));
        Set<String> stooges = new HashSet<>(Arrays.asList("Larry", "Moe", "Curly"));
        Set<String> aflCio = union(guys, stooges);
        System.out.println(aflCio);

        // 제네릭 싱글턴 팩터리 패턴 사용 예제
        String[] strings = {"jute", "hemp", "nylon"};
        UnaryFunction<String> sameString = identityFunction();
        for (String s: strings)
            System.out.println(sameString.apply(s));

        Number[] numbers = {1, 2.0, 3L};
        UnaryFunction<Number> sameNumber = identityFunction();
        for (Number n: numbers)
            System.out.println(sameNumber.apply(n));
    }

    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // 이 정적 팩터리 메서드를 이용하면, 한 객체로 여러 형인자(T)를 얻을 수 있다.
    // IDENTITY_FUNCTION은 무상태 객체고 형인자는 비한정 인자(unbounded)
    // 모든 자료형이 같은 객체를 공유해도 안전하다.
    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identityFunction() {
        return (UnaryFunction<T>) IDENTITY_FUNCTION;
    }
}
