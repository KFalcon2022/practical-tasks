package com.walking.lesson28_generics1.task2;

import com.walking.lesson28_generics1.task2.model.Wrapper;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
public class Main {
    public static void main(String[] args) {
        Wrapper w1 = new Wrapper(new Object());
        Wrapper w2 = new Wrapper(null);

        System.out.println(w1.isNull());
        System.out.println(w2.isNull());
    }
}
