package com.walking.lesson28_generics1.task3;

import com.walking.lesson28_generics1.task3.service.ValueSearcher;

/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
public class Main {
    public static void main(String[] args) {

        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        ValueSearcher<Integer> integerValueSearcher = new ValueSearcher<>(integers);

        int found = integerValueSearcher.search(4);
        System.out.println(found);

        System.out.println(integerValueSearcher.search(8));
    }
}
