package chap03_싱글턴패턴.classes;

public class Elvis {
    //public static final Elvis INSTANCE = new Elvis(); // public final 필드를 이용한 싱글턴
    private static final Elvis INSTANCE = new Elvis(); // 정적 팩터리 메서드를 이용한 싱글턴

    // reflection, AccessibleObject.setAccessible 을 이용하면 private 생성자도 다른 곳에서 부를 수 있다.
    private Elvis() {
        // INSTANCE 는 클래스 변수이므로, 이 클래스가 쓰이게 될 때 무조건 첫 번째로 초기화된다.
        // 만약, 다른 곳에서 위에 적힌 리플렉션, setAccessible 을 사용하더라도, 그게 두 번째가 되므로, 런타임 에러를 발생시킨다.
        if (INSTANCE != null)
            throw new RuntimeException("Elvis, Do not call private constructor.");
        System.out.println("Elvis private constructor called.");
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void printHello() {
        System.out.println("Hello");
    }
}
