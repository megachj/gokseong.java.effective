## 제네릭 메서드 만들기
예제처럼 만들도록 한다.

## 재귀적 자료형 한정
> 재귀적 자료형 한정(recursive type bound)은 형인자가 포함된 표현식으로 형인자를 한정하는 것을 말한다.

```java
public interface Comparable<T> {
    int compare(T o);
}

// 재귀적 자료형 한정, 원소끼리 상호 비교 가능성 표현
// T 는 Comparable<T>를 확장한 하위 자료형인데, 한정하는 문장에 T가 들어가 있기 때문에 재귀적 자료형 한정이라고 한다.
// 결국, 자료형 한정 <T extends Comparable<T>>는 "자기 자신과 비교 가능한 모든 자료형 T"라는 의미가 된다.
public static <T extends Comparable<T>> T max(List<T> list) {
    ...
}
```