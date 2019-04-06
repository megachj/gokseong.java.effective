package chap05_제네릭.rule29_다형성컨테이너.classes;

import java.util.HashMap;
import java.util.Map;

// 형 안전 다형성(heterogeneous) 컨테이너 패턴
public class Favorites_29 {
    /*
    NOTE: 아래 favorites 맵의 키는 비한정적 와일드카드가 쓰였는데, 그러면 맵에 원소를 못 넣지 않나?
    와일드카드 자료형이 중첩되어 있는 것에 주의해야 한다.
    와일드카드가 쓰인 곳이 Map이 아니라, 키이다. 즉 Map<?, Object>로 쓰인게 아니라, Key인 Class<?>에 쓰였다는 말이다.
    이 의미는 맵이 서로 다른 형인자 자료형을 값으로 가질 수 있다는 의미다.(키가 모두 다른 클래스이므로)
    즉, Class<String>인 키도 있고(당연히 값은 String), Class<Integer> 키도 있다(당연히 값은 정수).
     */
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null)
            throw new NullPointerException("Type is null");
        //favorites.put(type, instance);

        // 위처럼 작성하면, 키에 담긴 타입정보와 값에 담긴 타입정보는 문법상으로 아무런 관련이 없다.
        // 그래서 동적 형변환으로 실행시간에도 형 안전성을 확보하자.
        favorites.put(type, type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        // cast 메서드는 자바의 형변환 연산자의 동적(dynamic) 버전
        return type.cast(favorites.get(type));
    }
}
