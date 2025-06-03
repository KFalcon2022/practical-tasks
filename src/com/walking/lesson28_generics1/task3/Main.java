package com.walking.lesson28_generics1.task3;

import com.walking.lesson28_generics1.task3.service.SearchValue;

/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] values = new Integer[] {1, 2, 3, 4, 5};

        SearchValue<Integer> searchValue = new SearchValue<>(values);

        System.out.println(searchValue.searchValue(3));
        System.out.println(searchValue.searchValue(7));
    }
}
