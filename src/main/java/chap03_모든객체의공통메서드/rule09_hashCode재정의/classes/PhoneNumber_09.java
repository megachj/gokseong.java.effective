package chap03_모든객체의공통메서드.rule09_hashCode재정의.classes;

import lombok.Getter;

@Getter
public final class PhoneNumber_09 {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber_09(int areaCode, int prefix, int lineNumber) {
        rangecheck(areaCode, 999, "area code");
        rangecheck(prefix, 999, "prefix");
        rangecheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangecheck(int arg, int max, String name) {
        if (arg < 0 || arg > max)
            throw new IllegalArgumentException(name + ": " + arg);
    }

    @Override
    public boolean equals(Object o) {
        // 1. == 연산자로 같은 객체인지 확인
        if (this == o)
            return true;
        // 2. 같은 클래스인지 확인
        if (!(o instanceof PhoneNumber_09))
            return false;
        // 3. 형변환
        PhoneNumber_09 pn = (PhoneNumber_09) o;
        // 4. 모든 필드가 같은지 검사, 다를 확률이 높은 것부터 비교한다.
        return lineNumber == pn.lineNumber && prefix == pn.getPrefix() && areaCode == pn.getAreaCode();
    }

    // hashCode를 재정의하지 않으면 문제가 발생한다.
    @Override
    public int hashCode() {
        //return super.hashCode();

        // hashCode 지침에 따라 재정의
        int result = 17;
        result = 31 * result + (int) areaCode;
        result = 31 * result + (int) prefix;
        result = 31 * result + (int) lineNumber;
        return result;
    }
}
