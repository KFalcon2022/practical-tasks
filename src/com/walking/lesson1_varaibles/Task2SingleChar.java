package com.walking.lesson1_varaibles;

/**
 * Используя одну переменную типа char вывести свое имя в консоль.
 */
public class Task2SingleChar {
    public static void main(String[] args) {
        char charName = 'Н';

        System.out.print("Вывод через один char без перехода на новую строку: " + charName);
        charName = 'и';
        System.out.print(charName);
        charName = 'к';
        System.out.print(charName);
        charName = 'и';
        System.out.print(charName);
        charName = 'т';
        System.out.print(charName);
        charName = 'а';
        System.out.print(charName);
        System.out.println();
    }
}
