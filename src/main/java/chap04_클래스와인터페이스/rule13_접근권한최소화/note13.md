## 접근 권한 원칙
> 클래스, 멤버는 가능한 한 접근 불가능하도록 만들어라.

## 최상위 클래스
최상위 레벨(중첩되지 않은) 인터페이스, 클래스는 `package-private`, `public`
두 가지 접근권한을 가질 수 있다.
* public: 해당 패키지의 API 일부가 되므로, 신중하게 정해야 한다.
* package-private: 이미 해당 패키지 안에서만 사용할 수 있는, 구현 세부 사항이다.
    * 해당 클래스가 한 개의 클래스에서만 사용되면, 사용되는 클래스에 private 으로 중첩해서 만드는게 좋다.

## 멤버
필드, 메서드, 중첩 클래스, 중첩 인터페이스는 모든 접근 권한을 가질 수 있다.
* private: 선언된 최상위 레벨 클래스 내부에서만 접근 가능
* package-private: 패같은 패키지 내의 아무 클래스에서 접근 가능
* protected: 선언된 클래스, 선언된 클래스의 같은 패키지, 하위 클래스에서 접근 가능
* public: 모든 곳에서 접근 가능

private, package-private 는 세부 구현 사항  
protected, public 은 공개 API 일부
* private, package-private 멤버들은 구현 세부사항인데, `Seriallizable`을
구현하는 클래스 멤버면 공개 API 속에 새어나갈 수 있다.

## 결론
* 접근 권한을 가능한 낮추라.
* public static final 필드 제외한 모든 필드는 public 선언하지 마라.
* public static final 필드가 참조하는 객체는 변경 불가능한 객체로 만들라.