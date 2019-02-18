package chap33_EnumMap;

import chap33_EnumMap.classes.Herb;

import java.util.*;

/**
 * EnumMap 사용
 */
public class Main33 {
    public static void main(String[] args) {
        List<Herb> garden = new ArrayList<>();
        garden.add(new Herb("A", Herb.Type.ANNUAL));
        garden.add(new Herb("B", Herb.Type.ANNUAL));
        garden.add(new Herb("C", Herb.Type.ANNUAL));
        garden.add(new Herb("D", Herb.Type.BIENNIAL));
        garden.add(new Herb("E", Herb.Type.BIENNIAL));
        garden.add(new Herb("F", Herb.Type.PERENNIAL));

        // EnumMap 생성
        Map<Herb.Type, Set<Herb>> herbsByType =
                new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);

        // 각 enum 상수로 EnumMap의 key 생성
        for(Herb.Type t: Herb.Type.values()) {
            herbsByType.put(t, new HashSet<>());
        }

        // 각 key에 value 넣기
        for(Herb h : garden) {
            herbsByType.get(h.getType()).add(h);
        }

        System.out.println(herbsByType);
    }
}
