package chap03_모든객체의공통메서드.rule12_Comparable구현;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.TreeSet;

public class Main12 {
    public static void main(String[] args) {
        TreeSet<Person> personTreeSet = new TreeSet<>();
        personTreeSet.add(new Person("choe", 28));
        personTreeSet.add(new Person("kim", 30));
        personTreeSet.add(new Person("Lee", 15));

        System.out.println(personTreeSet);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Person {
        private String name;
        private int age;
    }
}
