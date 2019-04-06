package chap03_모든객체의공통메서드.rule11_clone재정의.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
final public class FinalX_11 {
    // 기본형 멤버 변수
    private int intA;

    // 기본형 클래스 변수
    private static int staticIntB;


    // 참조형 멤버 변수
    private RefX_11 refA;

    // 참조형 클래스 변수
    private static RefX_11 staticRefB;
}
