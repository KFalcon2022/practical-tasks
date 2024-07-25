package com.walking.lesson28_generics1.task2;

import com.walking.lesson28_generics1.task2.model.GenericAllObject;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
public class Main {
    public static void main(String[] args) {
        GenericAllObject<Integer> integerGenericAllObject = new GenericAllObject<>(10);
        GenericAllObject<Double> doubleGenericAllObject = new GenericAllObject<>(null);
        GenericAllObject<Float> floatGenericAllObject = new GenericAllObject<>(12F);
        GenericAllObject<Long> longGenericAllObject = new GenericAllObject<>(22L);
        GenericAllObject<Byte> byteGenericAllObject = new GenericAllObject<>(null);
        GenericAllObject<Boolean> booleanGenericAllObject = new GenericAllObject<>(true);

        System.out.println(booleanGenericAllObject.isNull());
        System.out.println(integerGenericAllObject.isNull());
        System.out.println(doubleGenericAllObject.isNull());
        System.out.println(floatGenericAllObject.isNull());
        System.out.println(longGenericAllObject.isNull());
        System.out.println(byteGenericAllObject.isNull());
    }
}
