package chap06_enum과어노테이션.rule30_enum정의.enums;

import lombok.Getter;

/**
 * [java 문법]
 *
 * enum의 정체는 클래스인데, enum 상수 마다의 오직 객체 한 개씩을 가지고 있는 놈.
 */
@Getter
public enum Planet_30 {
    MERCURY (100, 10), // public static final Planet MERCURY = new Planet(100, 10);
    VENUS   (200, 20), // public static final Planet MERCURY = new Planet(100, 10);
    EARTH   (300, 30), // public static final Planet MERCURY = new Planet(100, 10);
    MARS    (400, 40); // public static final Planet MERCURY = new Planet(100, 10);

    // 필수 인자
    private final double mass;
    private final double radius;
    private final double surfaceGravity;

    private String nickname;

    // Planet 클래스 상수
    private static final double G = 6.67300E-11;

    // enum은 외부에서 생성할 수 없어, 접근제한자 생략.
    // private이 강제됨, 생략은 되어있지만, package-default가 아니라 private임.
    Planet_30(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
        nickname = "";
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;
    }
}
