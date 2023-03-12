package com.walking.lesson28_generics1.task2;

import com.walking.lesson28_generics1.task2.model.Generic;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
public class Main {
    public static void main(String[] args) {
        Integer a = null;
        String b = " ";

        Generic <Integer> intGen = new Generic<>(a);
        Generic <String> strGen = new Generic<>(b);

        System.out.println(intGen.nullCheck(intGen.getObj()));
        System.out.println(strGen.nullCheck(strGen.getObj()));
    }
}
