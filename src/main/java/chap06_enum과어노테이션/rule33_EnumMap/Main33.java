package chap06_enum과어노테이션.rule33_EnumMap;

import chap06_enum과어노테이션.rule33_EnumMap.classes.Herb_33;

import java.util.*;

/**
 * EnumMap 사용
 */
public class Main33 {
    public static void main(String[] args) {
        List<Herb_33> garden = new ArrayList<>();
        garden.add(new Herb_33("A", Herb_33.Type.ANNUAL));
        garden.add(new Herb_33("B", Herb_33.Type.ANNUAL));
        garden.add(new Herb_33("C", Herb_33.Type.ANNUAL));
        garden.add(new Herb_33("D", Herb_33.Type.BIENNIAL));
        garden.add(new Herb_33("E", Herb_33.Type.BIENNIAL));
        garden.add(new Herb_33("F", Herb_33.Type.PERENNIAL));

        // EnumMap 생성
        Map<Herb_33.Type, Set<Herb_33>> herbsByType =
                new EnumMap<Herb_33.Type, Set<Herb_33>>(Herb_33.Type.class);

        // 각 enum 상수로 EnumMap의 key 생성
        for(Herb_33.Type t: Herb_33.Type.values()) {
            herbsByType.put(t, new HashSet<>());
        }

        // 각 key에 value 넣기
        for(Herb_33 h : garden) {
            herbsByType.get(h.getType()).add(h);
        }

        System.out.println(herbsByType);
    }
}
