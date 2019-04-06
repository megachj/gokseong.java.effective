package chap06_enum과어노테이션.rule32_EnumSet;

import chap06_enum과어노테이션.rule32_EnumSet.classes.Text_32;

import java.util.EnumSet;

public class Main32 {
    public static void main(String[] args) {
        Text_32 text = new Text_32();

        // EnumSet의 static 메소드 of를 이용해 파라미터를 전달할 수 있다.
        text.applyStyles(EnumSet.of(Text_32.Style.BOLD, Text_32.Style.ITALIC));
    }
}