package chap30.classes;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * [java 문법]
 *
 * 이 클래스는 enum과 거의 같은 역할을 한다.
 * 상수 마다의 재정의된 메서드를 제공하는 기능만 없다고 보면된다.
 * 그리고 enum은 enum 상수가 항상 가장 먼저 나와야 하지만, 일반 클래스이므로 이런 제약사항이 존재하지 않는다.
 *
 * 다음으로 클래스 및 enum의 규칙을 보자.
 *
 * 클래스는 첫 객체가 생성될 때, 클래스에 대한 메모리영역이 할당되는 것 같다.
 * 예를 들어, 클래스가 정의되고, 사용이 되지 않는다면, 해당 클래스(static 변수, static 메서드)는 메모리에 올라가지 않는다.
 *
 * static 필드는 클래스 자체에 속하는 것인데, 이 static 필드들은 선언된 순서대로, 메모리 할당 및 초기화가 된다.
 * 그 이유는 밑의 Map 필드를 p1, p2 밑에 선언해두면, 생성자에서 Map이 null이 되어 Map에 put하려고 하면 NPE가 발생한다.
 * 그래서 p1, p2를 Map에 넣어주려면, static 영역에서 put해주어야 한다.
 * 하지만 Map이 가장 먼저 선언이 되었다면, 이미 Map이 HashMap을 생성했기 때문에, 생성자에서 put해도 아무런 문제가 없다.
 */
@Getter
public class PrivatePerson {
    // 여기에 있다면, p1, p2가 생성자가 불러지기 전에 이미 Map이 있어서 NPE가 발생하지 않는다.
    // private static final Map<String, PrivatePerson> stringToPrivatePerson = new HashMap<>();

    private static final PrivatePerson p1 = new PrivatePerson("kim", 10);
    private static final PrivatePerson p2 = new PrivatePerson("choe", 20);

    // 여기 있는 경우엔, 생성자에서 보는 경우 null이 발생한다.
    private static final Map<String, PrivatePerson> stringToPrivatePerson = new HashMap<>();

    private final String name;
    private final int age;

    // 모든 static 필드가 할당 및 생성된 후 시작되는 영역
    // 그래서 이 곳에서 static 필드를 초기화 해주는 게 안전한 것이다.
    static {
        System.out.println(String.format("PrivatePerson static 영역, map: %s", stringToPrivatePerson));
        stringToPrivatePerson.put(p1.getName(), p1);
        stringToPrivatePerson.put(p2.getName(), p2);
    }

    private PrivatePerson(String name, int age) {
        this.name = name;
        this.age = age;

        System.out.println(String.format("PrivatePerson 생성자 영역, %s %d, map: %s", name, age, stringToPrivatePerson));
        // Map이 아래에 선언되어 있는 경우 NULL이므로 NPE 발생
        // stringToPrivatePerson.put(name, this);
    }

    public static PrivatePerson fromString(String name) {
        return stringToPrivatePerson.get(name);
    }
}
