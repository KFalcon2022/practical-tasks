package com.walking.lesson28_generics1.task3;

/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
public class Main {
    public static void main(String[] args) {

        ArrayClass<String> m1 = new ArrayClass<>(new String[]{"Lada", "Niva", "Volga"});
        ArrayClass<Integer> m2 = new ArrayClass<>(new Integer[]{5, 10, 15, 20, 25});

        System.out.println(m1.<String>findItem("Niva"));

        System.out.println(m2.<Integer>findItem(25));


    }
}
