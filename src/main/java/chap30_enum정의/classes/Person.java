package chap30_enum정의.classes;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Person {
    private final String name;
    private final int age;

    // 근데 이런 클래스 변수는 멀티 스레드 환경에서 안전하지 않을 것 같다.
    private static final Map<String, Person> stringToPerson = new HashMap<>();
    static {
        // 밖에서 어떤 객체가 만들어졌는지 알 수 없다.
    }

    // 그냥 클래스에선, static에 넣지 않아도 문제될 게 없다.
    // 왜냐하면, 이미 static 변수는 첫 객체가 만들어져 클래스(static 변수, static 메서드)가 만들어지는 시점에 초기화가 되었기 때문
    // 그래서 stringToPerson은 null이 아니라, HashMap이 되어 있다.
    public Person(String name, int age) {
        this.name = name;
        this.age = age;

        stringToPerson.put(name, this);
    }

    public static Person fromString(String name) {
        return stringToPerson.get(name);
    }
}
