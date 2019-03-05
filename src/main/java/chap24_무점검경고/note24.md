## 컴파일러 무점검 경고 메시지
형 안정성을 위해 모든 무점검 경고(unchecked warning)을 모두 없애도록 노력하자.
* 무점검 형변환 경고(unchecked cast warning)
* 무점검 메서드 호출 경고(unchecked method invocation warning)
* 무점검 제네릭 배열 생성 경고(unchecked generic array creation warning)
* 무점검 변환 경고(unchecked conversion warning)

제거할 수 없는 경고 메시지는 형 안정성이 확실할 때만 `@SupressWarnings("unchecked")` 어노테이션을 사용하자.  
SupressWarning은 개별 지역변수부터 클래스 전체까지 어떤 단위로도 적용할 수 있지만, 가능한 작은 범위에 적용하자.  
그리고 이 어노테이션을 사용하는 곳에 **왜 형 안정성을 위반하지 않는지에 대한 주석을 반드시 붙여라.**

### 예제
```java
public class ListArray <T> {
    public <T> T[] toArray(T[] a) {
        if(a.length < size)
            // 여기에서 unchecked cast 경고 메시지 발생
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        System.arraycopy(elements, 0, a, 0, size);
        if(a.length > size)
            a[size] = null;
        return a;
    }
    
    // 위 메서드에서 경고를 없애자.
    // @SuppressWarnings 적용 범위를 위해 지역 변수 사용
    public <T> T[] toArray(T[] a) {
        if(a.length < size)
            // 파라미터 자료형 T[]와 동일하므로 정확하다.
            @SuppressWarnings("unchecked")
            T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());
            return result;
        System.arraycopy(elements, 0, a, 0, size);
        if(a.length > size)
            a[size] = null;
        return a; 
    }
}
```