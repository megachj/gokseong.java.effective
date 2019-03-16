package chap05_제네릭.rule28_한정적와일드카드.classes;

import lombok.Getter;
import lombok.Setter;

/**
 * Developer 는 Job의 하위 클래스이다.
 * Job은 Comparable<Job>을 구현하고 있다.
 * 따라서, Developer는 Comparable<Job>을 구현한다.
 * Comparable<Developer>을 구현할 수 없다. 구현하면, 컴파일 에러 발생한다.
 */
@Getter
@Setter
public class Developer extends Job {
    int level;

    public Developer(int sellery, int level) {
        super(sellery);
        this.level = level;
    }
}
