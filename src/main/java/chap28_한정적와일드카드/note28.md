## 한정적 와일드카드
### 하위 자료형, 상위 자료형으로 한정하기
예제의 StackWildcard의 pushAll, popAll 메서드와 같이 extends, super를 사용할 수 있다.
* \<? extends E\>: E의 하위 자료형, E 자신도 자신의 하위 자료형에 포함
* \<? super E\>: E의 상위 자료형, E 자신도 자신의 상위 자료형에 포함

### 자료형 유추와 명시적 형인자
컴파일러가 자료형을 정확히 유추하지 못할 경우, 명시적 형인자를 통해 자료형을 명시할 수 있다.  
`클래스.<형인자>메서드(인자)`와 같이 사용하면 된다. 예시 참고.  
* 책에 나온 예제를 JDK 1.8로 컴파일할 경우, 자료형 유추가 잘 된다.

## PECS: Produce - Extends, Consumer - Super
유연성을 최대화하려면, 객체 생산자(producer)나 소비자(consumer) 역할을 하는 메서드 인자의
자료형은 와일드카드 자료형으로 해야한다. 만약 메서드 인자가 생산자면서, 소비자라면 와일드카드
자료형은 쓸모가 없다.
* 생산자 역할: 인자 자기자신은 소비되며 남을 생산, pushAll을 떠올리면 된다.
* 소비자 역할: 남이 소비되며 인자 자기자신을 생산, popAll을 떠올리면 된다.

### 예제
```java
// 이전
public static <E> Set<E> union(Set<E> s1, Set<E> s2);

// PECS 적용
public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2);
```
**반환값에는 와일드카드 자료형을 쓰면 안 된다.**  
왜냐하면 이 메서드를 호출하는 클라이언트 코드에서도 와일드카드 자료형을 명시해야 하기 때문이다.

## PECS에 대한 고찰
아래와 같은 클래스를 생각해보자.
* 상위: Job
* 중간: Doctor / Developer
* 하위: Surgeon, Dentist / CppDeveloper, JavaDeveloper

### 메서드 인자의 소비자, 생산자
그리고 이 클래스들의 객체가 예제에서 만들어둔 StackWildcard의 원소라고 하자.  
T == Developer 클래스, 즉 StackWildcard\<Developer\>가 있다고 하자.  

생산자일 경우 \<? extends T\>이면, Developer, CppDeveloper, JavaDeveloper가 인자로 들어올 수 있다.  
그래서 원소는 Developer, CppDeveloper, JavaDeveloper 객체들이 스택에 들어가 있다.  

소비자일 경우 \<? super T\>이면, Developer, Job이 인자로 들어올 수 있다.  
인자로 Developer, Job 모두 들어와도 앞에서 넣어둔 원소를 인자 리스트에 모두 받을 수 있다.  
반대로, 소비자에 \<? extends T\>였다면, CppDeveloper가 인자로 올 수 있고, 이 경우에
Developer, JavaDeveloper를 리스트에 넣을 수 없게 된다.

결국, 어떤 클래스에 소비자용, 생산자용 메서드가 있으면, PECS를 적용하면 유연성이 증가한다.  
그리고 와일드카드를 적용할 때 PECS를 잘 맞춰야지, 안 그러면 위 예시처럼 이상해질 수 있다.

### 형인자의 소비자, 생산자
```java
public static <T extends Comparable<T>> T max(List<T> list);

// PECS 적용
// 메서드 인자 생산자, 형인자 소비자
public static <T extends Comparable<? super T>> T max(List<? extends T> list);
```
이 예시는 Job, Developer, JavaDeveloper 클래스와 Main28 테스트에서 알아볼 수 있다.

## 형인자와 와일드카드 사이의 이원성(Duality) 문제
메서드 가운데 상당수는 와일드카드로도, 형인자로도 선언될 수 있다.  
그럼 어떤 것을 사용해야할까? 물론 실제로 꼼꼼히 생각해봐야 겠지만, 원칙은 존재한다.  

**형인자가 메서드 선언에 단 한군데 나타난다면 해당 인자를 와일드카드로 바꾸는 것이다.**  
* 비한정적 형인자이면 비한정적 와일드카드로 바꾼다.
* 한정적 형인자이면 한정적 와일드카드로 바꾼다.
```
// 비한정적 형인자 -> 비한정적 와일드카드
List<E> -> List<?>

// 한정적 형인자 -> 한정적 와일드카드
List<E extends Number> -> List<? extends Number>
```
예시는 Swaper를 보면 된다.