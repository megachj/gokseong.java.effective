package chap04_클래스와인터페이스.rule16_계승대신구성;

import chap04_클래스와인터페이스.rule16_계승대신구성.classes.ForwardingSet;
import chap04_클래스와인터페이스.rule16_계승대신구성.classes.InstrumentedHashSet;
import chap04_클래스와인터페이스.rule16_계승대신구성.classes.InstrumentedSet;

import java.util.Arrays;
import java.util.HashSet;

public class Main16 {
    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());

        InstrumentedSet<String> s2 = new InstrumentedSet<>(new HashSet<>());
        s2.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(s2.getAddCount());
    }
}
