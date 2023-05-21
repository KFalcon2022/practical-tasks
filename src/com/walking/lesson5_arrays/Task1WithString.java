package com.walking.lesson5_arrays;

/**
 * Создать массив char, заполненный буквами своего имени в верном порядке.
 * Используя этот массив, вывести свое имя в консоль.
 * Предварительно собрать значения массива в переменную типа String.
 */
public class Task1WithString {
    public static void main(String[] args) {
        char[] nameArray = new char[] {'М', 'а', 'к', 'с', 'и', 'м'};
        String name = "";
        for (char ch : nameArray) {
            name += ch;
        }
        System.out.print(name);
    }
}
