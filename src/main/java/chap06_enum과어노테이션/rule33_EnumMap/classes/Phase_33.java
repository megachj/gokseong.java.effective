package chap06_enum과어노테이션.rule33_EnumMap.classes;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * EnumMap Key로 두 개의 enum 상수를 사용하고 싶을 때 응용 예제.
 * EnumMap을 중첩해서 enum 쌍에 대응되는 데이터 저장.
 */
public enum Phase_33 {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final Phase_33 src;
        private final Phase_33 dst;
        Transition(Phase_33 src, Phase_33 dst) {
            this.src = src;
            this.dst = dst;
        }

        private static final Map<Phase_33, Map<Phase_33, Transition>> m = new HashMap<>();
        static{
            for(Phase_33 p: Phase_33.values())
                m.put(p, new EnumMap<Phase_33, Transition>(Phase_33.class));

            for(Transition trans: Transition.values())
                m.get(trans.src).put(trans.dst, trans);
        }

        public static Transition from(Phase_33 src, Phase_33 dst) {
            return m.get(src).get(dst);
        }
    }
}
