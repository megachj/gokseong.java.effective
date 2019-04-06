package chap03_모든객체의공통메서드.rule11_clone재정의;

import chap03_모든객체의공통메서드.rule11_clone재정의.classes.RefX_11;

public class Main11 {
    private final RefX_11 refA = new RefX_11(0, "AAA", new int[]{1, 2, 3});
    private RefX_11 refB = new RefX_11(1, "BBB", new int[]{4, 5, 6});

    public static void func(RefX_11 param) {
        System.out.println(param);
    }

    public void func2() {
        func(refA);
    }

    public static void main(String[] args) {
        Main11 main11 = new Main11();
        RefX_11 copyA = main11.refA.clone();
        RefX_11 copyB = main11.refB.clone();

        if ( main11.refA == copyA)
            System.out.println("A는 같다.");
        if ( main11.refB == copyB)
            System.out.println("B는 같다.");

        copyA.setStr("CCC");
        copyB.setStr("DDD");
        System.out.println(main11.refA.getStr());
        System.out.println(main11.refB.getStr());
        System.out.println(copyA.getStr());
        System.out.println(copyB.getStr());

        copyA.getIntArr()[0] = 100;
        copyB.getIntArr()[0] = 100;
        System.out.println(main11.refA.getIntArr()[0]);
        System.out.println(main11.refB.getIntArr()[0]);
        System.out.println(copyA.getIntArr()[0]);
        System.out.println(copyB.getIntArr()[0]);

        String A = "aaa";
        String B = new String("aaa");
        String C = "aaa";
        String D = new String("aaa").intern();
        System.out.println(A == B);
        System.out.println(A == C);
        System.out.println(A == D);
        System.out.println(B == C);
        System.out.println(B == D);
        System.out.println(C == D);

        String E = new String("bbb");
        String F = new String("bbb").intern();
        System.out.println(E == F);
    }
}
