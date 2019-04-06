## Comparable 인터페이스
```java
public interface Comparable<T> {
    int compareTo(T t);
}
```

### compareTo 메서드 일반 규약
> 자신 객체와 인자로 주어진 객체를 비교한다.  
자신 객체 값이 인자로 주어진 객체보다 작으면 `음수`, 같으면 `0`, 크면 `양수`를 반환한다.
인자 자료형이 비교 불가능한 자료형이면 `ClassCastException 예외`를 던진다.

주의할 것이 하나 있다.  
x.compareTo(y) == 0 이지만, x.equals(y)는 `false`일 수 있다.  
true인게 좋지만 절대적이지는 않다는 말이다. 예로 BigDecimal 객체가 있다.

### 결론
Comparable을 구현하면, 정렬하거나, 최대/최소치를 계산하기도 간단하고, 컬렉션을
정렬된 상태로 유지하기도 쉽다. 값 클래스들은 Comparable 인터페이스 구현을 하면 좋다.

TreeSet, TreeMap 처럼 정렬되는 컬렉션들이 오동작할 수 있다.
예제를 보면 Comparable을 구현하지 않으면 TreeSet 사용시 ClassCastException이 발생한 것을 볼 수 있다.