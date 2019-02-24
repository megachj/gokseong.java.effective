## 배열과 제네릭 자료형의 차이
> `배열`은 원소끼리 super-sub 관계면, 배열 자체도 super-sub 관계이다.  
`제네릭`은 타입이 super-sub에 상관없이, 다르면 무조건 다른 자료형이다.

**예제**  
```java
// 런타임에 예외 발생
// object(super) - Long(sub) 관계 -> Object[](super) - Long[](sub)
Object[] objectArray = new Long[1];
objectArray[0] = "..."; // ArrayStoreException 예외 발생

// 컴파일타임에 걸린다.
// Object(super) - Long(sub) 관계지만, List<Object> != List<Long> 그냥 다른 자료형이다.
List<Object> objectList = new ArrayList<Long>();
```

> `배열`은 실체화(reification)되는 자료형이다.  
위에서 본 것처럼 배열은 super-sub관계가 성립되어, super-sub관계를 만족하면 다른 자료형이 들어갈 수 있다.
이는, 런타임이 되어야 진짜 자료형을 알 수 있다는 것이다.  
`제네릭`은 컴파일타임에 자료형을 검사해, 이미 다 걸러내므로 런타임에는 타입 정보가 없다.

이로 인해 배열과 제네릭을 섞어 쓰기 어렵다.  
new List\<E\>[], new List\<String\>[], new E[]는 컴파일이 되지 않는다.  
컴파일하려고 하면 **제네릭 배열 생성(generic array creation)** 오류가 발생한다.  
