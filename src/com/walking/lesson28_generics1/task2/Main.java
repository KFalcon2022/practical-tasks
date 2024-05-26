package com.walking.lesson28_generics1.task2;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
public class Main {
    public static void main(String[] args) {
        SomeType<String> stringSomeType = new SomeType<>();
        System.out.println(stringSomeType.isNull());
        stringSomeType.setValue("qwert");
        System.out.println(stringSomeType.isNull());
    }
}
