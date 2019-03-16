package chap05_제네릭.rule28_한정적와일드카드.classes;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class StackWildcard<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public StackWildcard() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // pop된 top은 null을 가리킴.
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // E 객체 생산자 역할을 하는 인자에 대한 와일드카드 자료형
    public void pushAll(Iterable<? extends E> src) {
        for (E e: src)
            push(e);
    }

    // E 소비자 역할을 하는 인자에 대한 와일드카드 자료형
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty())
            dst.add(pop());
    }
}
