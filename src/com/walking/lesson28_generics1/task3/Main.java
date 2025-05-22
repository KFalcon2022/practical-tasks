package com.walking.lesson28_generics1.task3;

import com.walking.lesson28_generics1.task3.service.GenericArray;

/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
public class Main {
    public static void main(String[] args) {
        Character[] arr = new Character[] {'a', 'r', 't', '2', 'y', 'u', '-'};
        GenericArray<Character> charArr = new GenericArray<>(arr);
        System.out.println(charArr.find('y'));
        System.out.println(charArr.find('i'));
    }
}
