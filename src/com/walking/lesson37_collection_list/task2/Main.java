package com.walking.lesson37_collection_list.task2;

import com.walking.lesson37_collection_list.task2.collection.MyCollection;

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
        MyCollection<String> strings = new MyCollection<>();
        strings.add("hello");
        strings.add("how");
        strings.add("are");
        strings.add("you");

        System.out.println(Arrays.toString(strings.toArray()));

        MyCollection<String> col2 = new MyCollection<>("how");
        strings.retainAll(col2);
        System.out.println(Arrays.toString(strings.toArray()));
    }
}
