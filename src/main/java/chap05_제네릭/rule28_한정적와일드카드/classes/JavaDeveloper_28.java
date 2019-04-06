package chap05_제네릭.rule28_한정적와일드카드.classes;

import lombok.*;

/**
 * JavaDeveloper 는 Developer의 하위 클래스이고, Developer는 Job의 하위 클래스이다.
 * Job은 Comparable<Job>을 구현하고 있다.
 * 따라서, JavaDeveloper는 Comparable<Job>을 구현한다.
 * Comparable<Developer>을 구현할 수 없다. 구현하면, 컴파일 에러 발생한다.
 */
@Getter
@Setter
public class JavaDeveloper_28 extends Developer_28 {
    int javaLevel;

    public JavaDeveloper_28(int sellery, int level, int javaLevel) {
        super(sellery, level);
        this.javaLevel = javaLevel;
    }
}
