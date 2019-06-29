package chap04_클래스와인터페이스.rule16_계승대신구성.classes;

import java.util.Collection;
import java.util.HashSet;

// 계승을 잘못 사용한 사례
public class InstrumentedHashSet_16<E> extends HashSet<E> {
    // 요소를 삽입하려는 횟수
    private int addCount = 0;

    public InstrumentedHashSet_16() {}

    public InstrumentedHashSet_16(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    // addAll 로 추가하면, 2배로 잘 못 계산되게 된다.
    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();

        // super.addAll 은 내부적으로 add 를 호출하는데,
        // //이 클래스에서 add 를 override 했으므로 위의 add 메서드를 호출한다.
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
