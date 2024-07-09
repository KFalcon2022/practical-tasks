package com.walking.lesson28_generics1.task3;

import com.walking.lesson28_generics1.task3.model.ArrayWrapper;

/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
public class Main {
    public static void main(String[] args) {
        ArrayWrapper<String> array=new ArrayWrapper<>(new String[]{"1","2","3"});
        System.out.println(array.findValue("4"));
    }
}
