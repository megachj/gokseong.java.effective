package chap32;

import chap32.classes.Text;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        Text text = new Text();

        // EnumSet의 static 메소드 of를 이용해 파라미터를 전달할 수 있다.
        text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC));
    }
}