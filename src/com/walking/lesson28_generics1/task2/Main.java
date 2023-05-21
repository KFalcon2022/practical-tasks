package com.walking.lesson28_generics1.task2;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
import com.walking.lesson28_generics1.task2.model.ObjectNullComparator;
public class Main {
    public static void main(String[] args) {

        System.out.println(new ObjectNullComparator<Integer>( new Integer(5)).isNull());
        System.out.println(new ObjectNullComparator<Integer>( null ).isNull());

    }
}
