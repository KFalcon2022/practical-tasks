package com.walking.lesson28_generics1.task2;

import com.walking.lesson28_generics1.task2.model.Wrapper;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
public class Main {
    public static void main(String[] args) {
        Wrapper<String> s=new Wrapper<>("Field");
        System.out.println(s.isNull());
        System.out.println(s.getField());
        Wrapper<Integer> i=new Wrapper<>(666);
        System.out.println(i.isNull());
        System.out.println(i.getField());
        Wrapper<Double> d=new Wrapper<>(null);
        System.out.println(d.isNull());
    }
}
