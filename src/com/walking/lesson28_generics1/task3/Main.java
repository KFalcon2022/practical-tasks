package com.walking.lesson28_generics1.task3;

import com.walking.lesson28_generics1.task3.utility.ArrayUtility;
import com.walking.lesson28_generics1.task3.utility.ElementNotFoundException;

/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
public class Main {
    public static void main(String[] args) {
        String[] strings = new String[]{"1", "2", "3", "4"};

        ArrayUtility<String> stringArrayUtility = new ArrayUtility<>(strings);

        try {
            String found = stringArrayUtility.find("5");
            System.out.printf("Значение %S найдено\n", found);
        } catch (ElementNotFoundException e) {
            System.out.printf("значение %S не найдено\n", e.getValue());
        }

        Integer[] integers = new Integer[]{1, 2, 3, 4};

        ArrayUtility<Integer> integerArrayUtility = new ArrayUtility<>(integers);

        try {
            Integer found = integerArrayUtility.find(null);
            System.out.printf("Значение %S найдено\n", found);
        } catch (ElementNotFoundException e) {
            System.out.printf("значение %S не найдено\n", e.getValue());
        }
    }
}
