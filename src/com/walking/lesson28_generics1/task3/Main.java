package com.walking.lesson28_generics1.task3;


import com.walking.lesson28_generics1.task3.model.ServiceArray;

/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
public class Main {
    public static void main(String[] args) {

        ServiceArray<Integer> integerServiceArray = new ServiceArray<>(new Integer[]{1,2,3,4,5,6,7,8});

        System.out.println(integerServiceArray.searchElement(5));
        System.out.println(integerServiceArray.searchElement(0));

    }
}
