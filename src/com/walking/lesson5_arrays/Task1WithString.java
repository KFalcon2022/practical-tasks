package com.walking.lesson5_arrays;

/**
 * Создать массив char, заполненный буквами своего имени в верном порядке.
 * Используя этот массив, вывести свое имя в консоль.
 * Предварительно собрать значения массива в переменную типа String.
 */
public class Task1WithString {
    public static void main(String[] args) {
        char[] array = {'G', 'a', 'l', 'i', 'n', 'a'};
        String name = "";
        for (char element: array){
            name = name + element;
        }
        System.out.println(name);
    }
}
