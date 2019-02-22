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
| 자료형 토큰(type token) | String.class |  |

**제네릭 클래스, 인터페이스**는 선언부에 형인자가 포함된 클래스, 인터페이스를 말한다.  
List\<E\> 와 같은게 제네릭 인터페이스이다.

**제네릭 자료형**은 제네릭 클래스, 인터페이스를 말한다. 
각 제네릭 자료형은 형인자 자료형 집합을 정의한다.  
* 형식 형인자(formal type parameter): List\<E\>의 E와 같은 것
* 실 형인자(actual type parameter): List<\String\>의 String과 같은 것

## 무인자 자료형
각 제네릭 자료형은 새로운 **무인자 자료형**을 정의하는데, 실 형인자 없이 사용되는 것을 말한다.  
그냥 List와 같이 \<\>이 없는 것을 말한다.

무인자 자료형을 사용하면 형 안정성이 사라지고(컴파일 시점에 타입을 체크하지 않음), 제네릭의 장점인 표현력
측면에서 손해를 본다.

이렇게 좋지 않은데, 허용한 이유는 자바 1.5 미만에서의 호환성 때문이다. 그래서 1.5부터는 사용하지
않는 것이 좋다. 모든 자료형을 허용하고 싶다면 실 형인자에 Object를 넣으면 된다.

### 무인자 자료형과 Object 자료형의 차이
무인자 자료형은 컴파일 시점에 타입검사를 안한다.  
Object 자료형은 컴파일 시점에 타입검사를 해서, 안전하다.  
Main23 파일에서 확인하자.

## 비한정적 와일드카드 자료형(unbounded wildcard type)
제네릭 자료형을 쓰고 싶으나, 실제 형인자를 모르거나, 신경쓰고 싶지 않을 때 `?`를 쓴다.  

예를들어 Set\<Object\> 로 파라미터를 받으면, Set\<String\>, Set\<int\>는 해당 메서드에 넘겨줄 수 없다.
그래서 이럴 때 Set\<?\>로 파라미터를 받으면, 위와 같은 것을 넘길 수 있다.

### 무인자 자료형과 비한정 와일드카드 자료형과 차이
예를들어 Set이라고 할때, 자료형이 없으므로 아무 타입이나 요소를 삽입할 수 있다.
반면 비한정 와일드카드 자료형은 null이외의 값을 요소로 삽입할 수 없는 규칙이 있다.
Main23 파일에서 확인하자.

## 무인자 자료형을 쓸 수 밖에 없는 경우
