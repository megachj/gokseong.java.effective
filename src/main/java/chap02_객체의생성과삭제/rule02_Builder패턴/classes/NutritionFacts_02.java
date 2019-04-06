package chap02_객체의생성과삭제.rule02_Builder패턴.classes;

// 빌더 패턴
public class NutritionFacts_02 {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // 필수 인자
        private final int servingSize;
        private final int servings;

        // 선택 인자 - 기본값으로 초기화
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) { calories = val; return this; }
        public Builder fat(int val) { fat = val; return this; }
        public Builder carbohydrate(int val) { carbohydrate = val; return this; }
        public Builder sodium(int val) { sodium = val; return this; }

        public NutritionFacts_02 build() {
            return new NutritionFacts_02(this);
        }
    }

    private NutritionFacts_02(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
