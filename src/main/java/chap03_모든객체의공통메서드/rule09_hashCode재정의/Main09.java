package chap03_모든객체의공통메서드.rule09_hashCode재정의;

import chap03_모든객체의공통메서드.rule09_hashCode재정의.classes.PhoneNumber;

import java.util.HashMap;
import java.util.Map;

public class Main09 {
    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707, 867, 5309), "Jenny");
        String name = m.get(new PhoneNumber(707, 867, 5309));
        // hashCode가 재정의되지 않은 경우 null
        // 재정의 된 경우 "Jenny"
        System.out.println(name);
    }
}
