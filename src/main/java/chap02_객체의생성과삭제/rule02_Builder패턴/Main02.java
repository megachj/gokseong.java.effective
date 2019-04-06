package chap02_객체의생성과삭제.rule02_Builder패턴;

import chap02_객체의생성과삭제.rule02_Builder패턴.classes.NutritionFacts_02;

public class Main02 {
    public static void main(String[] args) {
        NutritionFacts_02 nutritionFacts = (new NutritionFacts_02.Builder(1, 2)).calories(100).build();
    }
}
