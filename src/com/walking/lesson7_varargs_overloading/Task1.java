package com.walking.lesson7_varargs_overloading;

/**
 * Написать программу, которая объединяет любое количество строк,
 * объединяя их через пробел.
 * Реализацию конкатенации строк вынести в отдельный метод.
 */
public class Task1 {
    public static void main(String[] args) {
        System.out.println(concateStrings("Я", "Программирую", "На","Java"));
    }

    static String concateStrings(String... strings) {
        String result = "";
        for (String string : strings) {
            result += string;
        }
        return result;
    }
}
