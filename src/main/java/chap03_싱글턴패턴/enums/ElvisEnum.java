package chap03_싱글턴패턴.enums;

// Enum 싱글턴
public enum ElvisEnum {
    INSTANCE;

    public void printHello() {
        System.out.println("Hello");
    }
}
