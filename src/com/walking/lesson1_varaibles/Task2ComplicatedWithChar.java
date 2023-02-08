package com.walking.lesson1_varaibles;

/**
 * Усложнение для внимательных: вывести ваше имя посимвольно,
 * где каждая буква — на новой строке, не используя System.out.println().
 * Реализуется с использованием char.
 */
public class Task2ComplicatedWithChar {
    public static void main(String[] args) {
        char nextLine = '\n';
        char c = 'G';
        System.out.print(c);
        System.out.print(nextLine);
        c = 'a';
        System.out.print(c);
        System.out.print(nextLine);
        c = 'l';
        System.out.print(c);
        System.out.print(nextLine);
        c = 'i';
        System.out.print(c);
        System.out.print(nextLine);
        c = 'n';
        System.out.print(c);
        System.out.print(nextLine);
        c = 'a';
        System.out.print(c);
    }
}
