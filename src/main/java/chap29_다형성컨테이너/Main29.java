package chap29_다형성컨테이너;

import chap29_다형성컨테이너.classes.Favorites;

import java.util.ArrayList;

public class Main29 {
    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);
        f.putFavorite(String[].class, new String[]{"hello", "java"});
        //f.putFavorite(List<String>.class, Arrays.asList(new String[]{"hello", "cpp"})); // 실체화 불가능 자료형인 형인자 자료형은 Class 키로 들어갈 수 없다.
        ArrayList list = new ArrayList();
        list.add(1);
        list.add("one");
        f.putFavorite(ArrayList.class, list);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        String[] favoriteStringArray = f.getFavorite(String[].class);
        ArrayList favoriteList = f.getFavorite(ArrayList.class);
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
        System.out.printf("%s %s%n", favoriteStringArray[0], favoriteStringArray[1]);
        System.out.println(favoriteList);
    }
}
