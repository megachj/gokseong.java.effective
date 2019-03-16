package chap02_객체의생성과삭제.rule02_Builder패턴;

import chap02_객체의생성과삭제.rule02_Builder패턴.classes.NutritionFacts;

public class Main02 {
    public static void main(String[] args) {
        NutritionFacts nutritionFacts = (new NutritionFacts.Builder(1, 2)).calories(100).build();
    }
}
