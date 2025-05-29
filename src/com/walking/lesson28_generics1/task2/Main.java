package com.walking.lesson28_generics1.task2;

import com.walking.lesson28_generics1.task2.service.GenericObject;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
public class Main {
    public static void main(String[] args) {
        GenericObject<String> stringObj = new GenericObject<>("Hello");
        GenericObject<Number> numberObj = new GenericObject<>(null);
        print(stringObj);
        print(numberObj);
    }

    public static void print(GenericObject object) {
        if (object.isNull()) {
            throw new RuntimeException("Object is null");
        }

        System.out.println(object.get());
    }
}
