package com.walking.lesson37_collection_list.task2;

import com.walking.lesson37_collection_list.task2.structure.CollectionList;

import java.util.Arrays;

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
        CollectionList<?> test = initList();

        System.out.println(Arrays.toString(test.toArray()));

    }

    private static CollectionList<? extends Number> initList() {
        CollectionList<Double> initList = new CollectionList<>();
        initList.add(1.2);
        initList.add(2.3);
        initList.add(3.4);
        initList.add(5.6);
        initList.add(6.7);
        initList.add(7.8);

        return initList;
    }
}
