## 제네릭 메서드 만들기
예제처럼 만들도록 한다.

## 재귀적 자료형 한정
> 재귀적 자료형 한정(recursive type bound)은 형인자가 포함된 표현식으로 형인자를 한정하는 것을 말한다.

```java
public interface Comparable<T> {
    int compare(T o);
}
```