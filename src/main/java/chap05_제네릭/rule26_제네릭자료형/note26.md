## 제네릭 자료형 만들기
제네릭 자료형으로 만들면, 형 안전성이 증가하므로 좋다.  

예제의 Stack도 처음엔 Object 타입의 elements 였지만, 형인자(type parameter) E를 클래스 선언부에
선언하고, elements를 E 타입으로 만들었다.  
하지만 이 경우에 Object를 모두 E로 바꾸면 생성자에서 컴파일 에러가 발생한다.(제네릭 배열 생성 불가)  
해결을 위한 방법은 두 가지가 있는데, 첫 번째는 예시대로 생성자에서 Object[]로 만들고 E[]로 형변환 하는 것이다.  

두 번째 방법은 elements를 Object[]로 그대로 두고, 이 elements를 사용하는 곳마다 E[]로 형변환 하는 것이다.
```java
// 필드 elements는 Object[] 타입으로 둔다.
private Object[] elements;

// pop 메서드에서 나오는 컴파일 에러를 잡는다.
public E pop() {
    if (size == 0)
        throw new EmptyStackException();
    
    // 무점검이므로 경고 메시지는 없애준다. 형 안전성을 충분히 고려한 뒤에..
    @SuppressWarnings("unchecked")
    E result = (E) elements[--size]; // elements는 원소가 Object 타입이므로 result에 담을 때 형변환

    elements[size] = null;
    return result;
}
```

두 가지 방법 중 생성자에만 형 변환하는 예제의 첫 번째 방법이 더 낫다. 두 번째 방법은 만약 저렇게 형변환
하는 부분이 늘어나면 모든 부분에 처리를 해줘야 한다.

### 제네릭에 형인자(type parameter)로 기본 자료형은 사용할 수 없다.
자바 제네릭 자료형 시스템의 근본적 한계 때문에 int, double같은 기본 자료형은 못 사용한다.  
대신 객체화된 기본 자료형(boxed primitive type)을 사용하면 된다.(Integer, Double 등)

### 한정적 형인자: 형인자를 제한하기
```java
class DelayQueue<E extends Delayed> implements BlockingQueue<E>;
```
DelayQueue 클래스는 E를 형인자(type parameter)로 받는데, 이 E는 Delayed 클래스를 `확장한(extends)
하위 클래스`로 제한한다. (덧 붙여 이 클래스는 BlockingQueue\<E\> 인터페이스를 구현한다.)