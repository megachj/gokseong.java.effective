package chap03_싱글턴패턴.classes;

import java.io.Serializable;

/**
 * 싱글턴 클래스를 직렬화 기능(Serializable) 클래스로 만들기 위해서 아래 작업을 해야한다.
 * 1. Serializable 인터페이스 구현
 * 2. 모든 필드에 transient 선언
 * 3. readResolve 메서드를 추가
 */
public class ElvisWithSerializable implements Serializable {
    transient private static final ElvisWithSerializable INSTANCE = new ElvisWithSerializable();

    private ElvisWithSerializable() {
        if (INSTANCE != null)
            throw new RuntimeException("ElvisWithSerializable, Do not call private constructor.");
        System.out.println("ElvisWithSerializable private constructor called.");
    }

    public static ElvisWithSerializable getInstance() {
        return INSTANCE;
    }

    // 싱글턴 상태를 유지하기 위한 readResolve 구현
    private Object readResolve() {
        // 동일한 객체가 반환되도록 하는 동시에, 가짜 ElvisWithSerializable 객체는 gc 가 처리하도록 한다.
        return INSTANCE;
    }
}
