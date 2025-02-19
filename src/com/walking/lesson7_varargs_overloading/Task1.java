package com.walking.lesson7_varargs_overloading;

import java.io.IOException;

/**
 * Написать программу, которая объединяет любое количество строк,
 * объединяя их через пробел.
 * Реализацию конкатенации строк вынести в отдельный метод.
 */
public class Task1 {
    public static void main(String[] args) throws IOException {

        String[] words = {"Если", "б", "мишки", "были", "пчёлами", "то", "они", "бы", "нипочём"};

        System.out.println(concatinateString(words));
    }

    static String concatinateString(String[] words) {

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append(" ");
        }
        return result.toString();
    }
}
