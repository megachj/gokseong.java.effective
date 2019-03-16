## 형 안전 다형성 컨테이너
제네릭은 Set, Map같은 `컬렉션(collection)`과 ThreadLocal, AtomicReference처럼
하나의 원소만을 담는 `컨테이너(container)`에 가장 많이 쓰인다.  

여기서 형인자는 해당 컨테이너의 타입을 결정해준다.
그래서 컨테이너별로 형인자의 수는 고정된다.
* Set은 집합에 담길 자료형 하나 필요
* Map은 키, 값에 담길 자료형 둘 필요

하지만, 유연하게 여러 타입을 저장하는 컨테이너가 필요하다면?  
이때의 쉬운 해결책으로 Map을 필드로 두고, 컨테이너 대신 `키(key)에 형인자를 지정`하는 것이다.

예시로 Favorites를 보면 된다.  
여기서 인자화된 키 역할은 Class 객체가 한다. 자바 1.5부터 Class는 제네릭 클래스가 되었으므로 가능하다.
class 리터럴의 자료형은 Class가 아니라, Class\<T\>이다.
* 예) String.class의 자료형은 Class\<String\>, Integer.class의 자료형은 Class\<Integer\>

컴파일 시간 자료형, 실행시간 자료형 정보를 메서드에 전달할 목적으로 `class 리터럴`을 이용하는 경우에,
그런 class 리터럴을 `자료형 토큰(type token)`이라 부른다.