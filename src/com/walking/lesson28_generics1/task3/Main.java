package com.walking.lesson28_generics1.task3;

import com.walking.lesson28_generics1.task3.exeption.ValueNotFound;
import com.walking.lesson28_generics1.task3.model.GenericArray;


/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
public class Main {
    public static void main(String[] args) throws ValueNotFound{
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        GenericArray<Integer> integerGenericArray = new GenericArray<>(array);

        System.out.println(integerGenericArray.getValue(22));
    }
}
