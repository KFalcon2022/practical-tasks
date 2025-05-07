package com.walking.lesson37_collection_list.task2;

import com.walking.lesson37_collection_list.task2.collection.MyLinkedCollection;

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
        MyLinkedCollection<Integer> coll = initColl();
        System.out.println("Размер: " + coll.size());

        coll.remove(2);
        System.out.println("Размер: " + coll.size());

        coll.add(9);
        System.out.println(coll.getElem());
    }

    private static MyLinkedCollection<Integer> initColl() {
        MyLinkedCollection<Integer> coll = new MyLinkedCollection<>();
        coll.add(1);
        coll.add(2);
        coll.add(3);
        coll.add(4);
        coll.add(5);
        coll.add(6);
        coll.add(7);
        coll.add(8);

        return coll;
    }
}
