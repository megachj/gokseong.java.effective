package chap02_객체의생성과삭제.rule05_불필요한객체;

public class Main05 {
    public static void main(String[] args) {
        // s1 은 새로운 객체를 생성, s2 와 s3 은 동일한 객체 재사용
        String s1 = new String("stringette"); // 새로운 객체
        String s2 = "stringette";
        String s3 = "stringette";
        if (s1 != s2) System.out.println("s1 != s2");
        if (s1 != s3) System.out.println("s1 != s3");
        if (s2 == s3) System.out.println("s2 == s3");

        // 정적 팩터리 메서드 valueOf는 같은 객체를 전달
        Boolean b1 = new Boolean("true");
        Boolean b2 = Boolean.valueOf("true");
        if (b1 != b2) System.out.println("b1 != b2");
        if (b1 != Boolean.TRUE) System.out.println("b1 != Boolean.TRUE");
        if (b2 == Boolean.TRUE) System.out.println("b2 == Boolean.TRUE");

    }
}
