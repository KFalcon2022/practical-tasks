package com.walking.lesson28_generics1.task2;

import com.walking.lesson28_generics1.task2.model.NotNullObject;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
public class Main {
    public static void main(String[] args) {

        NotNullObject<Object> notNullObject = new NotNullObject<>(new Object());
        System.out.println(notNullObject.isNull());

        NotNullObject<Object> nullObject = new NotNullObject<>(null);
        System.out.println(nullObject.isNull());

    }
}
