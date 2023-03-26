package com.walking.lesson28_generics1.task2;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
public class Main {
    public static void main(String[] args) {
        NullChecker <String> o1 = new NullChecker<>();
        NullChecker <String> o2 = new NullChecker<>("");
        NullChecker <Integer> o3 = new NullChecker<>();
        NullChecker <Integer> o4 = new NullChecker<>(55);

        System.out.println(o1.check());
        System.out.println(o2.check());
        System.out.println(o3.check());
        System.out.println(o4.check());
    }
}
