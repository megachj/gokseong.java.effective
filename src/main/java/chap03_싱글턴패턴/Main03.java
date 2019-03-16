package chap03_싱글턴패턴;

import chap03_싱글턴패턴.classes.Elvis;

import java.lang.reflect.Constructor;

public class Main03 {
    public static void main(String[] args) throws Exception {
        // 정적 팩터리 메서드
        Elvis elvis = Elvis.getInstance();
        elvis.printHello();

        // 리플렉션과 setAccessible 메서드를 통해 private 생성자의 호출 권한을 획득
        Constructor<?> constructor = Elvis.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Elvis p = (Elvis) constructor.newInstance();
        p.printHello();
    }
}
