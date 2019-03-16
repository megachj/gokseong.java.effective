package chap05_제네릭.rule28_한정적와일드카드;

import chap05_제네릭.rule26_제네릭자료형.classes.Stack;
import chap05_제네릭.rule28_한정적와일드카드.classes.Developer;
import chap05_제네릭.rule28_한정적와일드카드.classes.JavaDeveloper;
import chap05_제네릭.rule28_한정적와일드카드.classes.MaxFinder;
import chap05_제네릭.rule28_한정적와일드카드.classes.StackWildcard;

import java.util.*;

public class Main28 {
    public static void main(String[] args) {
        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = () -> Arrays.asList(new Integer[]{1, 2, 3, 4}).iterator();
        Collection<Object> objects = new ArrayList<>();

        // Number - Integer는 상하 관계가 있지만, StackWildcard<Number> - StackWildcard<Integer>는 전혀 다른 자료형이다.
        // 그래서 아래는 컴파일 에러가 난다.
        //numberStack.pushAll(integers);
        //numberStack.popAll(objects);

        StackWildcard<Number> numberStackWildcard = new StackWildcard<>();
        numberStackWildcard.pushAll(integers); // 와일드카드 자료형을 써서 Number의 하위 자료형(자기 자신 포함)은 모두 처리 가능
        numberStackWildcard.popAll(objects);

        // NOTE: 자료형 유추, 명시적 형인자 예제
        Set<Integer> integerSet = new HashSet<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
        Set<Double> doubleSet = new HashSet<>(Arrays.asList(new Double[]{1.5, 2.5, 3.5, 4.5, 5.5}));

        Set<Number> numbers = union(integerSet, doubleSet); // 컴파일러의 자료형 유추
        Set<Number> numbers1 = Main28.<Number>union(integerSet, doubleSet); // 명시적 형인자 선언(E = Number)

        System.out.println(numbers);
        System.out.println(numbers1);

        // NOTE: PECS 고찰
        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer(3600, 5));
        developers.add(new JavaDeveloper(4800, 5, 10));

        //Developer a = MaxFinder.max(developers); // Developer는 Comparable<Job>을 구현했기 때문에, 형인자가 맞지 않는다.
        Developer a1 = MaxFinder.maxWithWildcard(developers);
        System.out.println(a1);
    }

    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}
