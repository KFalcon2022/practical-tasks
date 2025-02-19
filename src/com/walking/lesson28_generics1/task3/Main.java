package com.walking.lesson28_generics1.task3;

/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
public class Main {
    public static void main(String[] args) {
        ArrayClass<Integer> integerArrayClass = new ArrayClass<>(new Integer[]{1, 2, 3});
        System.out.println(integerArrayClass.findElement(5));
    }
}
