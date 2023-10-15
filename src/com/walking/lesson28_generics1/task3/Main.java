package com.walking.lesson28_generics1.task3;

import com.walking.lesson28_generics1.task3.model.ArrayHandler;

/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Integer[] arrayInt = new Integer[]{1,3,2,6,7};
        String[] arrayString = new String[]{"One","two","Four"};

        ArrayHandler<String> arrayHandlerString = new ArrayHandler<>(arrayString);
        ArrayHandler<Integer> arrayHandlerInt = new ArrayHandler<>(arrayInt);

        System.out.println(arrayHandlerInt.findValue(6));
        System.out.println(arrayHandlerString.findValue("two"));
        System.out.println(arrayHandlerInt.findValue(8));


    }
}
