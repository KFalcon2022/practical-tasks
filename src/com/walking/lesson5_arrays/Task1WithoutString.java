package com.walking.lesson5_arrays;

/**
 * Создать массив char, заполненный буквами своего имени в верном порядке.
 * Используя этот массив, вывести свое имя в консоль.
 * Не использовать переменную типа String.
 */
public class Task1WithoutString {
    public static void main(String[] args) {
        char[] array = {'G', 'a', 'l', 'i', 'n', 'a'};
        for (char element: array){
            System.out.print(element);
        }
    }
}
