package chap04_클래스와인터페이스.rule17_계승의설계와문서.classes;

public class Super_17 {
    // 생성자가 재정의 가능 메서드를 호출하는 잘못된 사례
    public Super_17() {
        overrideMe();
    }

    public void overrideMe() {}
}
