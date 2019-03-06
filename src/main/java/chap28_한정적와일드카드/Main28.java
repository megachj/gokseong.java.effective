package chap28_한정적와일드카드;

import chap26_제네릭자료형.classes.Stack;
import chap28_한정적와일드카드.classes.StackWildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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
    }
}
