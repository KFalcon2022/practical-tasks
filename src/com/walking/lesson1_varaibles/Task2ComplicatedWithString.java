package com.walking.lesson1_varaibles;

/**
 * Усложнение для внимательных: вывести ваше имя посимвольно,
 * где каждая буква — на новой строке, не используя System.out.println().
 * Реализуется с использованием String.
 */
public class Task2ComplicatedWithString {
    public static void main(String[] args) {
        String stringName = "Никита";

        for (i = 0; i < stringName.toCharArray().length; i++) {
            System.out.print(stringName.toCharArray()[i] + "\n");
        }

    }
}
