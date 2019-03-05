package chap27_제네릭메서드;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main27 {
    public static void main(String[] args) {
        Set<String> guys = new HashSet<>(Arrays.asList(new String[]{"Tom", "Dick", "Harry"}));
        Set<String> stooges = new HashSet<>(Arrays.asList("Larry", "Moe", "Curly"));
        Set<String> aflCio = union(guys, stooges);
        System.out.println(aflCio);
    }

    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}
