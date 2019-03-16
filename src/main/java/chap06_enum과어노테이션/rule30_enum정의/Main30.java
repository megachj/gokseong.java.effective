package chap06_enum과어노테이션.rule30_enum정의;

import chap06_enum과어노테이션.rule30_enum정의.classes.PrivatePerson;
import chap06_enum과어노테이션.rule30_enum정의.enums.Operation;

/**
 * enum에 대해 자세히 알아보자.
 */
public class Main30 {
    public static void main(String[] args){
        System.out.println("rule30 main");

        Operation divide = Operation.DIVIDE;
        PrivatePerson.fromString("kim");
    }
}
