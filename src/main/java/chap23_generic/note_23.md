## 용어
| 용어 | 예 | 설명 |
| --- | --- | --- |
| 형인자 자료형(parameterized type) | List\<String\> |  |
| 실 형인자(actual type parameter) | String |  |
| 제네릭 자료형(generic type) | List\<E\> | |
| 형식 형인자(formal type parameter) | E | |
| 비한정적 와일드카드 자료형(unbounded wildcard type) | List\<?\> | |
| 무인자 자료형(raw type) | List | |
| 한정적 형인자(bounded type parameter) | \<E extends Number\> | |
| 재귀적 형 한정(recursive type bound) | \<T extends Comparable\<T\>\> | |
| 한정적 와일드카드 자료형(bounded wildcard type) | List\<? extends Number\> | |
| 제네릭 메서드(generic method) | static \<E\> List\<E\> asList(E[] a) | |
| 자료형 토큰(type token) | String.class | |