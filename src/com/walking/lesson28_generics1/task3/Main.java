package com.walking.lesson28_generics1.task3;

import com.walking.lesson28_generics1.task3.service.SearchInArray;

/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        SearchInArray<Integer> integerSearchService = new SearchInArray<>(integers);

        int found = integerSearchService.search(1);
        System.out.println(found);

     integerSearchService.search(8);
    }
}
