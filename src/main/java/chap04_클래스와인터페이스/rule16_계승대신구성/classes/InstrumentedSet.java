package chap04_클래스와인터페이스.rule16_계승대신구성.classes;

import java.util.Collection;
import java.util.Set;

// 계승 대신 구성을 사용하는 포장(wrapper) 클래스
// 이런 구현 기법을 장식자 패턴이라고 부른다.
public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
