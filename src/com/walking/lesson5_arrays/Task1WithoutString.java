package com.walking.lesson5_arrays;

/**
 * Создать массив char, заполненный буквами своего имени в верном порядке.
 * Используя этот массив, вывести свое имя в консоль.
 * Не использовать переменную типа String.
 */
public class Task1WithoutString {
    public static void main(String[] args) {
        char[] myName = {'Е', 'в', 'г', 'е', 'н', 'и', 'й'};
        for (char letter : myName) {
            System.out.print(letter);
        }
    }
}
