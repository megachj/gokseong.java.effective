package chap05_제네릭.rule28_한정적와일드카드.classes;

import java.util.Iterator;
import java.util.List;

public class MaxFinder {
    // 1. T는 Comparable<T>를 구현한 클래스의 하위 클래스여야 한다.
    // 2. 이때 T는 오직 T 클래스로 Comparable을 구현해야 한다.
    public static <T extends Comparable<T>> T max(List<? extends T> list){
        Iterator<? extends T> i = list.iterator();
        T result = i.next();
        while (i.hasNext()) {
            T t = i.next();
            if (t.compareTo(result) > 0)
                result = t;
        }
        return result;
    }

    // 1. T는 Comparable<? super T>를 구현한 클래스의 하위 클래스여야 한다.
    // 2. 이때 T는 상위 클래스로 Comparable을 구현해도 된다.
    public static <T extends Comparable<? super T>> T maxWithWildcard(List<? extends T> list) {
        /*
        NOTE: Iterator<T>를 쓰면 컴파일에러가 생기는 이유
        list는 T'을 원소로 갖는다. 그래서 iterator 메서드는 Iterator<T'>을 리턴한다.
        제네릭 타입인자가 상위 하위 관계를 갖더라도, 제네릭 타입인자는 전혀 다른 타입이다.(앞 절에서 나온 내용)
        그래서 T(상위) - T'(하위) 관계지만, Iterator<T>와 Iterator<T'>은 전혀 다른 타입이라, 받을 수가 없다.
        따라서 T'을 제네릭 타입인자로 적어주어야 한다. T' == <? extends T>
         */
        //Iterator<T> i = list.iterator();

        Iterator<? extends T> i = list.iterator();
        T result = i.next();
        while (i.hasNext()) {
            T t = i.next();
            if (t.compareTo(result) > 0)
                result = t;
        }
        return result;
    }
}
