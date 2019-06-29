## 계승은 역시나 위험. 설계와 문서가 없다면 하지마라.
어떤 클래스를 계승한 클래스를 만들려고 할 때 그에 관한 문서가 없다면 하지마라.
또 내가 계승 가능한 클래스를 만든다면, 그러한 설계와 문서를 갖춰야 한다.  
즉, **재정의 가능 메서드를 내부적으로 어떻게 사용하는지 반드시 문서에 남겨라는 것**이다.

java.util.AbstractCollection, public boolean remove(Object o) 의 문서를 보면, 제거할 때
iterator의 remove 메서드를 호출하고, iterator가 remove 메서드를 구현하고 있지 않으면
UnsupportedOperationException 예외가 발생한다고 쓰여져 있다.  
이 내용을 보면, iterator 의 remove 메서드가 어떤 영향을 주는지 정확히 명시되어 있다.

## 잘 고른 protected 메서드도 제공해야 한다.
효율적인 하위 클래스를 작성할 수 있도록 하려면, **클래스 내부 동작에 개입할 수 있는 훅(hooks)인
protected 메서드**를 제공해야 한다.

java.util.AbstractList, protected void removeRange(int fromIndex, int toIndex) 는
구현에 관한 문서를 제공하고, 구현체의 내부 구현을 잘 활용하면 연산 성능을 많이 올릴 수 있다고 한다.
따라서, protected 메서드로 제공해 override 할 수 있도록 한 것이다.

### 어떤 멤버를 protected 로 제공해야 할까?
하위 클래스를 직접 만들어 테스트해보는 수 밖에는 없다.

## 계승을 허용할 때 제약사항
상위 클래스의 `생성자`는 직접적, 간접적 `모두 재정의 가능 메서드`를 호출해서는 안 된다.  
왜냐하면, 하위 클래스의 생성자 보다 먼저 상위 클래스 생성자가 호출 되는데, 거기서 재정의한 메서드를
호출하면 하위 클래스가 만들어지지 않았으므로 오동작 할 수 있다.

상위 클래스가 Cloneable, Serializable 인터페이스를 구현할 경우, clone, readObject 메서드도 
직접적, 간접적 모두 재정의 가능한 메서드를 호출하지 않도록 주의해야 한다.
* 두 메서드 모두 생성자와 비슷하게 동작하므로 비슷한 규칙을 따라야 한다.
* readObject 메서드 에서 재정의 가능 메서드를 호출하면, 하위 클래스 객체의 상태가 완전히
역직렬화(deserialize)되기 전에 해당 메서드가 실행되어 버린다.
* clone 메서드의 경우, 하위 클래스의 clone 메서드가 복사본 객체 상태를 미처 수정하기 전에
해당 메서드가 실행되어 버릴 것이다.

상위 클래스가 Serializable 인터페이스를 구현하고, readResolve, writeReplace 메서드가 있다면
private 이 아니라 protected 로 선언해야 한다.
* private로 선언하면 하위 클래스는 해당 메서드들을 조용히 무시한다.
* 이것은 계승을 허용하기 위해 구현 세부사항을 클래스 API의 일부로 포함시켜야 하는 사례이다.

## 결론
계승에 맞게 설계하고 문서화하지 않은 클래스는 하위 클래스를 만들지 않아야 한다.  
하위 클래스 생성 금지 방법은 final 클래스로 만들거나, 모든 생성자를 private, package-private
로 선언하고, 생성자 대신 public 정적 팩터리 메서드를 추가하는 것이다.