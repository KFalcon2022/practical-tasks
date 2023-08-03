package com.walking.lesson28_generics1.task2;

import com.walking.lesson28_generics1.task2.model.WrapperClass;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
public class Main {
    public static void main(String[] args) {

        WrapperClass<Integer> nullClas = new WrapperClass<>(null);
        WrapperClass<String> stringWrapperClass = new WrapperClass<>(new String());

        System.out.println(nullClas.isNull());
        System.out.println(stringWrapperClass.isNull());
    }
}
