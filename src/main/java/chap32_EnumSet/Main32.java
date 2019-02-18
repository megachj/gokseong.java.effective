package chap32_EnumSet;

import chap32_EnumSet.classes.Text;

import java.util.EnumSet;

public class Main32 {
    public static void main(String[] args) {
        Text text = new Text();

        // EnumSet의 static 메소드 of를 이용해 파라미터를 전달할 수 있다.
        text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC));
    }
}