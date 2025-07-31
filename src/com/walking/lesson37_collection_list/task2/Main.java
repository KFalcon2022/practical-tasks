package com.walking.lesson37_collection_list.task2;

import com.walking.lesson37_collection_list.task2.collection.Stack;

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
        Stack<Integer> testStack = new Stack<>();
        testStack.addAll(List.of(1, 2, 3, 4, 5, 6, 7));
        testStack.add(8);

        System.out.println(testStack.contains(4));

        testStack.remove(3);

        for (Object i : testStack) {
            System.out.println(i);
            //Не могу понять, почему не могу вывести последный элемент "1" в консоль
            //Подсоби, пж
        }
    }
}
