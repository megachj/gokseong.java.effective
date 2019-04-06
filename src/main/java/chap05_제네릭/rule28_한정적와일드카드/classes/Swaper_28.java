package chap05_제네릭.rule28_한정적와일드카드.classes;

import java.util.List;

public class Swaper_28 {
    // 외부에서는 어떤 타입의 리스트라도, swap할 수 있도록 비한정 와일드카드를 사용하도록 해야 한다.
    public static void swap(List<?> list, int i, int j) {
        /*
        NOTE: 아래 swap 문장이 컴파일 에러나는 이유
        list는 비한정 와일드카드이다.
        비한정 와일드카드에는 null 이외의 값을 넣을 수 없다.
        따라서, set하면 컴파일에러가 발생한다.
        그래서 이 메서드에 들어온 리스트의 형인자가 실제 어떤 것인지 포착(capture)하기 위해 아래 메서드를 만들었다.
         */
        //list.set(i, list.set(j, list.get(i)));
        swapHelper(list, i, j);
    }

    // 와일드카드 자료형을 포착(capture)하기 위한 private 도움 메서드
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
}
