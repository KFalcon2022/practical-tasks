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
        Integer intArr[] = new Integer[]{
                new Integer(1),
                new Integer(2),
                new Integer(3),
        };

        ArraySearch<Integer> arraySearchInt = new ArraySearch<>(intArr);

        Integer searchedInt = arraySearchInt.search(new Integer(5));
        if ( searchedInt == null ) {
            System.out.println("not found");
        } else {
            System.out.println(searchedInt.toString());
        }
    }
}
