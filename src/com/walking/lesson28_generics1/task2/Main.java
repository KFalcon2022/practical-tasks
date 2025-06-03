package com.walking.lesson28_generics1.task2;

import com.walking.lesson28_generics1.task2.model.NullObjectCheck;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
public class Main {
    public static void main(String[] args) {
        NullObjectCheck<Object> nullObjectCheck = new NullObjectCheck<>(new Object());

        System.out.println(nullObjectCheck.isNull());
    }
}
