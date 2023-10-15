package com.walking.lesson28_generics1.task2;

import com.walking.lesson28_generics1.task2.model.ObjectWrap;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
public class Main {
    public static void main(String[] args) {
        ObjectWrap<String> objectString = new ObjectWrap<>("Bla Bla Bla");
        ObjectWrap<Integer> objectInt = new ObjectWrap<>(154);
        ObjectWrap<Boolean> objectBoolean = new ObjectWrap<>(true);
        ObjectWrap<Object> objectObj = new ObjectWrap<>(null);

        System.out.println(objectString.getObject());
        System.out.println(objectInt.getObject());
        System.out.println(objectBoolean.getObject());
        System.out.println(objectObj.getObject());
    }
}
