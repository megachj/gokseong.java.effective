package chap02_객체의생성과삭제.rule03_싱글턴패턴.enums;

// Enum 싱글턴
public enum ElvisEnum_03 {
    INSTANCE;

    public void printHello() {
        System.out.println("Hello");
    }
}
