package com.walking.lesson28_generics1.task2;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
public class Main {
    public static void main(String[] args) {
        Wrapper<Integer> integerWrapper = new Wrapper<>(null);
        Wrapper<String> stringWrapper = new Wrapper<>("Ololo");

        System.out.println(integerWrapper.wrapperNotEmpty());
    }
}
