package chap32.classes;

import java.util.Set;

/**
 * EnumSet - 비트 필드를 대신할 좋은 방법
 */
public class Text {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

    // 클라이언트에서 EnumSet.of를 이용해 파라미터를 전달할 수 있다.
    public void applyStyles(Set<Style> styles) {
        styles.stream().forEach(v -> {
            System.out.println(v.toString());
        });
    }
}
