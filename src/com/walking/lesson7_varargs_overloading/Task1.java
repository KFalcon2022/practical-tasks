package com.walking.lesson7_varargs_overloading;

/**
 * Написать программу, которая объединяет любое количество строк,
 * объединяя их через пробел.
 * Реализацию конкатенации строк вынести в отдельный метод.
 */
public class Task1 {
    public static void main(String[] args) {
        System.out.println(addString("Hello", "my", "new", "friend"));
    }

    static String addString(String ...str) {
        String s = "";
        for (String element : str) {
            s += element + " ";
        }
        s = s.trim();
        return s;
    }
}
