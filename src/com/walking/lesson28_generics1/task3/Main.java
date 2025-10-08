package com.walking.lesson28_generics1.task3;

import com.walking.lesson28_generics1.task3.service.FindValueArray;

/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String[] strings = new String[]{
                "First", "Second", "Aaaaa"
        };

        FindValueArray<String> stringFindValueArray = new FindValueArray<>(strings);

        System.out.println(stringFindValueArray.findValue("Aaaa"));
    }
}
