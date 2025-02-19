package com.walking.lesson37_collection_list.task2;

import com.walking.lesson37_collection_list.task2.structure.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Попробуйте реализовать собственную коллекцию, наследуясь от Collection.
 * За основу можно взять
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson28_generics1/task4">...</a>.
 * Если возникнет необходимость в имплементации методов,
 * не рассмотренных в статье - можете реализовать их как заглушки
 * (возвращая null/фиксированное значение по умолчанию/бросая исключение).
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        integers.add(1);
        integers.add(2);
        integers.add(1);
        integers.add(2);
        integers.add(1);
        integers.add(2);
        System.out.println("Добавление элементов:\n" + integers);

        int one = 1;
        integers.remove(one);
        integers.remove(1);
        integers.remove(Integer.valueOf(1));
        System.out.println("Удаление элементов:\n" + integers);

        List<Integer> integers12 = new ArrayList<>(List.of(1, 2));
        System.out.println("Содержит все элементы из integers12? " + integers.containsAll(integers12));

        integers.add(1);
        integers.add(1);
        integers.add(1);
        System.out.println("Повторное добавление элементов:\n" + integers);

        System.out.println("Содержит все элементы из integers12? " + integers.containsAll(integers12));

        integers.clear();
        System.out.println("Очистка:\n" + integers);

        integers.addAll(List.of(1, 2, 3, 2, 1));
        System.out.println("Добавление всех элементов другой коллекции:\n" + integers);

        integers.removeAll(integers12);
        System.out.println("Удаление всех элементов другой коллекции:\n" + integers);

        integers.retainAll(integers12);
        System.out.println("Удаление всех элементов отсутствующих в другой коллекции:\n" + integers);

        Object[] objectsArray = integers.toArray();
        Integer integer = (Integer) objectsArray[0];
        Integer[] integersArray = integers.toArray(new Integer[0]);
        Integer integer1 = integersArray[0];
        Number[] numbersArray = integers.toArray(new Number[0]);
        Number number = numbersArray[0];
        integer1 = (Integer) number;

        /*ArrayStoreException*/
        /*String[] stringsArray = integers.toArray(new String[0]);*/
    }
}

