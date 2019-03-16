package chap02_객체의생성과삭제.rule04_객체생성을막자;

import chap02_객체의생성과삭제.rule04_객체생성을막자.classes.UtilityClass;

public class Main04 {
    public static void main(String[] args) {
        //UtilityClass utilityClass = new UtilityClass(); // 객체 생성 x
        UtilityClass.printHello();
    }
}
