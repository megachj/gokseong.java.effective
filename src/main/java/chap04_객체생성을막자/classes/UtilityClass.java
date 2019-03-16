package chap04_객체생성을막자.classes;

// 객체를 만들 수 없는 유틸리티 클래스, 기본 생성자가 없으므로 하위 클래스도 만들 수 없다.
public class UtilityClass {

    // 기본 생성자가 자동 생성되지 못하도록 하여 객체 생성 방지
    private UtilityClass() {
        throw new AssertionError();
    }

    public static void printHello() {
        System.out.println("Hello");
    }
}
