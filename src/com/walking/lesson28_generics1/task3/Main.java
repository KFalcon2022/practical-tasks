package com.walking.lesson28_generics1.task3;

import com.walking.lesson28_generics1.task3.service.ArrayService;

/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
public class Main {
    public static void main(String[] args) {
        String[] strs = {"кот", "ток", "торт", "снег", "крот", "дым"};
        ArrayService<String> arrStr = new ArrayService<>(strs);
        System.out.println(arrStr.searchElement("кот"));

        Integer[] nums = {2, 3, 4, 5, 6};
        ArrayService<Integer> arrInt = new ArrayService<>(nums);
        System.out.println(arrInt.searchElement(7));

    }
}
