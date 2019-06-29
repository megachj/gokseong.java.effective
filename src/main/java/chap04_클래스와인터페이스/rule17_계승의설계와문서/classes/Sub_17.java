package chap04_클래스와인터페이스.rule17_계승의설계와문서.classes;

import java.util.Date;

public final class Sub_17 extends Super_17 {
    private final Date date; // 생성자가 초기화하는 final 필드

    Sub_17() {
        date = new Date();
    }

    @Override
    public void overrideMe() {
        System.out.println(date);
    }

    public static void main(String[] args) {
        Sub_17 sub_17 = new Sub_17();
        sub_17.overrideMe();
    }
}
