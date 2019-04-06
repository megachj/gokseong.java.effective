package chap02_객체의생성과삭제.rule05_불필요한객체.tests;

import org.junit.jupiter.api.Test;

public class performanceTest_05 {
    @Test
    public void autoBoxing() {
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    @Test
    public void primitive() {
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
