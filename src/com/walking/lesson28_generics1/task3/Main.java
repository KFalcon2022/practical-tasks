package com.walking.lesson28_generics1.task3;

/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
import com.walking.lesson28_generics1.task3.model.ArraySearch;

public class Main {
    public static void main(String[] args) {

        Integer intArr[] = new Integer[]{1,2,3,4};

        ArraySearch<Integer> arraySearchInt = new ArraySearch<>(intArr);

        System.out.println( arraySearchInt.search(1) );
        System.out.println( arraySearchInt.search(5) );
    }
}
