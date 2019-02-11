package chap30_enum정의.enums;

/**
 * [객체지향]
 *
 * enum안에 각 enum 상수마다 또 다른 enum 타입을 선언해 그룹을 나눔으로써, 유지보수에 안전하고, 코드 중복을 막을 수 있는
 * 객체지향적으로 좋은 코드를 작성할 수 있다.
 */
// 바깥 enum은 상수가 더 추가될 수 있는 상황. 예) 휴가일
public enum PayrollDay {
    // 요일은 7개 이지만, 요일에 따른 급여는 주중 주말 2가지이다.
    // 그리고, 이 요일에 휴가일이라는 상수가 또 추가될 수 있겠다.
    MONDAY(PayType.WEEKDAY),
    TUESDAY(PayType.WEEKDAY),
    WEDNESDAY(PayType.WEEKDAY),
    THURSDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    private final PayType payType;
    PayrollDay(PayType payType) { this.payType = payType; }

    // 급여 종류는 주중, 주말 2가지
    private enum PayType {
        WEEKDAY {
            @Override
            double overtimePay(double hrs, double payRate) {
                return hrs <= HOURS_PER_SHIFT ? 0 : (hrs - HOURS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            @Override
            double overtimePay(double hrs, double payRate) {
                return hrs * payRate / 2;
            }
        };
        private static final int HOURS_PER_SHIFT = 8;

        abstract double overtimePay(double hrs, double payRate);

        // 주중, 주말모두 basePay는 같지만, 초과근무비용이 다르므로 이 것은 상수마다 계산하게끔 추상메서드로 분리
        double pay(double hoursWorked, double payRate) {
            double basePay = hoursWorked * payRate;
            return basePay + overtimePay(hoursWorked, payRate);
        }
    }
}
