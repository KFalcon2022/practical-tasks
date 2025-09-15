package com.walking.lesson37_collection_list.task2;

import com.walking.lesson37_collection_list.task2.collection.MyCollection;

import java.util.ArrayList;
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

        MyCollection<Object> col1 = new MyCollection<>(34);
        col1.add("love");
        System.out.println(Arrays.toString(col1.toArray()));

        MyCollection<String> col2 = new MyCollection<>("45");
        col2.add("hello");
        System.out.println(Arrays.toString(col2.toArray()));
        col1.addAll(col2);
        System.out.println(Arrays.toString(col1.toArray()));
        System.out.println(col1.size());
        col2.clear();
        System.out.println(Arrays.toString(col2.toArray()));

    }
}
