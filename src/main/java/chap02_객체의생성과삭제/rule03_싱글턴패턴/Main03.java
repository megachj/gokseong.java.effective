package chap02_객체의생성과삭제.rule03_싱글턴패턴;

import chap02_객체의생성과삭제.rule03_싱글턴패턴.classes.Elvis_03;

import java.lang.reflect.Constructor;

public class Main03 {
    public static void main(String[] args) throws Exception {
        // 정적 팩터리 메서드
        Elvis_03 elvis = Elvis_03.getInstance();
        elvis.printHello();

        // 리플렉션과 setAccessible 메서드를 통해 private 생성자의 호출 권한을 획득
        Constructor<?> constructor = Elvis_03.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Elvis_03 p = (Elvis_03) constructor.newInstance();
        p.printHello();
    }
}
