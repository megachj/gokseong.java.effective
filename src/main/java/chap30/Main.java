package chap30;

import chap30.classes.PrivatePerson;
import chap30.enums.Operation;

/**
 * enum에 대해 자세히 알아보자.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("chap30 main");

        Operation divide = Operation.DIVIDE;
        PrivatePerson.fromString("kim");
    }
}
