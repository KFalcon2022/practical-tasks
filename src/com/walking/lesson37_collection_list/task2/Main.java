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
        Stack<Integer> stringStack = new Stack<>(1);

        stringStack.add(2);
        stringStack.add(3);
        stringStack.add(4);
        stringStack.add(5);
        stringStack.add(2);
        stringStack.add(32);

        stringStack.addAll(List.of(22,532,523));

        System.out.println(stringStack);
        stringStack.retainAll(List.of(1,2,1,22));

        System.out.println(stringStack);
    }
}
