package com.walking.lesson39_queue1.task3;

import java.util.Arrays;

/**
 * Реализуйте двусвязный список.
 * Реализуйте метод, разворачивающий список.
 * Также реализуйте метод, удаляющий все узлы, хэшкод элемента которых - четный.
 */
public class Main {
    public static void main(String[] args) {

        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);


        System.out.println(list);

        list.deleteNodeWithEvenHash();

        System.out.println(list);

    }
}