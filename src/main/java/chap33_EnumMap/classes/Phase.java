package chap33_EnumMap.classes;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * EnumMap Key로 두 개의 enum 상수를 사용하고 싶을 때 응용 예제.
 * EnumMap을 중첩해서 enum 쌍에 대응되는 데이터 저장.
 */
public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final Phase src;
        private final Phase dst;
        Transition(Phase src, Phase dst) {
            this.src = src;
            this.dst = dst;
        }

        private static final Map<Phase, Map<Phase, Transition>> m = new HashMap<>();
        static{
            for(Phase p: Phase.values())
                m.put(p, new EnumMap<Phase, Transition>(Phase.class));

            for(Transition trans: Transition.values())
                m.get(trans.src).put(trans.dst, trans);
        }

        public static Transition from(Phase src, Phase dst) {
            return m.get(src).get(dst);
        }
    }
}
