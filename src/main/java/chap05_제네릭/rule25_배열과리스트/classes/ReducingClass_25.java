package chap05_제네릭.rule25_배열과리스트.classes;

import chap05_제네릭.rule25_배열과리스트.interfaces.Function_25;
import chap05_제네릭.rule25_배열과리스트.interfaces.GenericFunction_25;

import java.util.ArrayList;
import java.util.List;

public class ReducingClass_25 {

    // 제네릭 없이 작성. 병행성 문제가 있다.
    static Object reduceWithoutConcurrency(List list, Function_25 f, Object initValue) {
        synchronized (list) {
            Object result = initValue;
            for(Object o: list)
                result = f.apply(result, o);
            return result;
        }
    }

    // 제네릭 없이 작성. 병행성 문제가 없다. 자바 1.5 이전의 가장 자연스러운 방법
    static Object reduceWithConcurrency(List list, Function_25 f, Object initValue) {
        Object[] snapshot = list.toArray(); //toArray 메서드는 내부적으로 리스트에 락을 건다.
        Object result = initValue;
        for(Object o: snapshot)
            result = f.apply(result, o);
        return result;
    }

    static <E> E reduceWithGenericArray(List<E> list, GenericFunction_25<E> f, E initValue) {
        //toArray는 Object[] 를 반환하므로, E[]로 형변환
        // 이렇게 하면, 컴파일은 되지만 unchecked cast 경고가 뜬다.
        E[] snapshot = (E[]) list.toArray();

        E result = initValue;
        for(E e: snapshot)
            result = f.apply(result, e);
        return result;
    }

    static <E> E reduceWithGenericList(List<E> list, GenericFunction_25<E> f, E initValue) {
        List<E> snapshot;
        synchronized (list) {
            snapshot = new ArrayList<>(list);
        }

        E result = initValue;
        for(E e: snapshot)
            result = f.apply(result, e);
        return result;
    }
}
