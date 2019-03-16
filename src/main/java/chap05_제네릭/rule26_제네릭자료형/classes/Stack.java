package chap05_제네릭.rule26_제네릭자료형.classes;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

// 클래스 변수, 인스턴스 변수에 사용되는 타입을 클래스 선언부에 형인자(type parameter)로 추가
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        //elements = new E[DEFAULT_INITIAL_CAPACITY]; //type parameter 'E' can't be instantiated directly

        // 해결1: Object배열로 만들고 E[]로 형변환, 이 경우 unchecked cast 경고 발생
        // 무점검 경고 부분의 형 안전성을 검증해보고, 안전하다면 suppressWarnings를 붙이자.
        // elements는 private 필드이고 클라에 반환되지 않으며 다른 어떤 메서드에도 전달되지 않는다.
        // 즉 이 객체가 아닌 다른 곳에서 elements를 변경하는 일은 없고, 오직 push 메서드에서만 원소가 추가되고 그 타입은 모두 E이다.
        // 따라서 경고를 제한해도 된다.
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

    // 와일드카드 자료형을 사용하지 않는 pushAll 메서드 - 문제가 있음
    public void pushAll(Iterable<E> src) {
        for (E e: src)
            push(e);
    }

    // 와일드카드 자료형 없이 구현, 문제가 있음
    public void popAll(Collection<E> dst) {
        while (!isEmpty())
            dst.add(pop());
    }
}
