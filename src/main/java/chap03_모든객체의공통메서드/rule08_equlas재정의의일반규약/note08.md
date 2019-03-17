## equals 메서드
equals 메서드는 재정의는 보통 하지 않는게 좋다.  
Object의 equals는 `오직 자기 자신`하고만 같도록 `equals가 정의`되어 있다.

## equals 재정의가 필요없는 경우
재정의하지 않아도 되는 경우는 아래 중 하나만 만족해도 된다.
* **각각의 객체가 고유하다.**  
값(value) 대신 활성 개체(active entity)를 나타내는 
Thread 같은 클래스가 이 조건을 만족한다.
* **상위 클래스에서 재정의한 equals가 하위 클래스에서 사용하기에 적당하다.**  
예를 들면, 대부분 Set, List, Map 클래스는 AbstractSet, AbstractList, AbstractMap의
equals 메서드를 그대로 사용한다.
* **클래스가 private, package-private 선언되었고, equals 메서드를 호출할 일이 없다.**  
근데 이런 경우에는 실수로 equals를 호출할 수도 있으므로 재정의해도 좋다.
    ```java
    private class PrivateExample {
        @Override
        public Boolean equals(Object o) {
            // 호출하면 안 되는 메서드를 호출했다는 뜻
            throw new AssertionError();
        }
    }
    ```
    
## equals를 재정의 해야하는 경우는?
아래와 같은 경우 재정의해야 한다.
* **객체 동일성(object equality)이 아닌 논리적 동일성(logical equality) 개념의 클래스일 때**  
이런 클래스를 값 클래스라고 부른다. 예로 Integer, Date는 값을 비교하기 위한 클래스이므로, 값으로 비교하도록 재정의하는 게 좋다.  
이 경우 재정의하면 `Map의 키`나 `Set의 원소`로 객체를 사용할 수 있는 장점이 생긴다.
* **상위 클래스의 equals가 하위 클래스의 필요를 충족하지 못할 때**  

값 클래스인데 enum 같이 개체 통제 기능(값 하나당 객체가 1개)을 사용하는 클래스는
객체 동일성이 논리적 동일성과 같아지므로 equals를 재정의할 필요가 없다.

## equals 의 조건
equals 메서드는 동치 관계를 구현한다. 다음 조건들을 모두 만족하면 동치 관계이다.
* 반사성(reflexive): null 아닌 참조 x가 있을 때, x.equals(x) == true
* 대칭성(symmetric): null 아닌 참조 x, y가 있을 때, x.equals(y) == y.equals(x)
* 추이성(transitive): null 아닌 참조 x, y, z가 있을 때, x.equals(y) == true 이고,
y.equals(z) == true 이면 x.equals(z) == true 이다.
* 일관성(consistent): null 아닌 참조 x, y가 있을 때, x.equals(y) 값은 항상 같아야 한다.
* null 아닌 참조 x에 대해서, x.equals(null)은 항상 false이다.

## equals의 메서드 구현시 지침
아래의 내용을 따라서 equals 메서드를 구현해야 한다.
1. **== 연산자를 사용해 equals의 인자가 자기 자신인지 검사한다.**  
만일 그렇다면, true를 반환하면 된다. 이건 단순히 성능 최적화를 위한 것이다.

2. **instanceof 연산자를 사용해 인자의 자료형이 정확한지 검사한다.**  
보통은 인자 자료형은 해당 클래스와 동일해야 한다. 하지만 클래스가 구현하는
인터페이스 가운데 하나가 되어야 할 때도 있는데, 이때는 instanceof 두 번째 피연산자에
해당 인터페이스를 사용해야 한다. Set, List, Map.Entry 같은 컬렉션 인터페이스들이
이런 특성을 가지고 있다.

3. **equals의 인자를 정확한 자료형으로 변환한다.**  
앞에서 instanceof를 이용한 검사 코드를 두어서, 형 변환은 반드시 성공하게 된다.

4. **"중요" 필드 각각이 인자로 주어진 객체의 해당 필드와 일치하는지 검사한다.**  
필드가 모두 일치하는 경우 true, 그렇지 않은 경우 false를 반환한다.  
검사 자료형이 인터페이스였다면 인터페이스 메서드를 통해 필드에 접근해야 한다.  
그리고 성능을 올리려면 다를 가능성이 가장 높거나 비교 비용이 낮은 필드부터 비교해야 한다.
    * 객체 참조 필드는 equals 메서드를 재귀적으로 호출해 검사한다.  
    * float, double 이외 기본 자료형은 == 로 비교한다.  
    * float 필드는 Float.compare, double 필드는 Double.compare 로 비교한다. 
    float, double을 특별 취급하는 이유는 float.NAN, -0.0f 같은 상수 때문이다.
    * 배열 필드는 각각 배열 원소마다 위 설명 사항을 적용해야 한다. 배열의 모든
    원소가 중요한 경우 JDK 1.5부터 제공되는 Arrays.equals 메서드 중 하나를 사용할 수도 있다.
    * 객체 참조 필드 중 null이 허용되는 것도 있다. 그런 경우 NPE를 피하기 위해 아래 숙어를 사용한다.
        ```java
        (field == null ? o.field == null : field.equals(o.field));
        
        // field와 o.field가 같을 때가 많다면, 아래처럼 하면 더 빠르다.
        (field == o.field || (field != null && field.equals(o.field)));
        ```

5. **대칭성, 추이성, 일관성 세 속성이 만족되는지 검토한다.**  
단위 테스트를 이용해 검사하면 좋다.

위의 지침에 따라 구현된 equals 메서드 예제는 규칙9의 PhoneNumber.equals를 보자.  
또 equals 구현시 주의할 점이 몇개 더 있다.
* equals를 구현할 땐 hashCode도 재정의하라.
* equals 메서드의 인자 형을 Object에서 다른 것으로 바꾸지 마라.  
이러면 재정의하는게 아니라, 새로운 메서드를 만드는 것이 되기 때문이다.