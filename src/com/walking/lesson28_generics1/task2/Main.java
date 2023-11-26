package com.walking.lesson28_generics1.task2;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
public class Main {
    public static void main(String[] args) {

        ExistObject<Object> m1 = new ExistObject<>(new Object());
        System.out.println(m1.checkThis());

        ExistObject<Object> m2 = new ExistObject<>(null);
        System.out.println(m2.checkThis());



    }
}
