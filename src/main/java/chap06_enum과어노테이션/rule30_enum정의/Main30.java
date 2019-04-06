package chap06_enum과어노테이션.rule30_enum정의;

import chap06_enum과어노테이션.rule30_enum정의.classes.PrivatePerson_30;
import chap06_enum과어노테이션.rule30_enum정의.enums.Operation_30;

/**
 * enum에 대해 자세히 알아보자.
 */
public class Main30 {
    public static void main(String[] args){
        System.out.println("rule30 main");

        Operation_30 divide = Operation_30.DIVIDE;
        PrivatePerson_30.fromString("kim");
    }
}
