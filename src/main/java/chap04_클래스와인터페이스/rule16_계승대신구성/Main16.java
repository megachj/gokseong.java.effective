package chap04_클래스와인터페이스.rule16_계승대신구성;

import chap04_클래스와인터페이스.rule16_계승대신구성.classes.InstrumentedHashSet_16;
import chap04_클래스와인터페이스.rule16_계승대신구성.classes.InstrumentedSet_16;

import java.util.Arrays;
import java.util.HashSet;

public class Main16 {
    public static void main(String[] args) {
        InstrumentedHashSet_16<String> s = new InstrumentedHashSet_16<>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());

        InstrumentedSet_16<String> s2 = new InstrumentedSet_16<>(new HashSet<>());
        s2.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(s2.getAddCount());
    }
}
