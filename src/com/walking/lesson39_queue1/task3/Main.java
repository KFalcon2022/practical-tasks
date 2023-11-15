package com.walking.lesson39_queue1.task3;

import com.walking.lesson39_queue1.collection.DoubleLinkedList;

/**
 * Реализуйте двусвязный список.
 * Реализуйте метод, разворачивающий список.
 * Также реализуйте метод, удаляющий все узлы, хэшкод элемента которых - четный.
 */
public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = initList();

        System.out.printf("First: %d, Last: %d\n", list.getTop(), list.getLast());

        list.reverseList();
        System.out.printf("First: %d, Last: %d\n", list.getTop(), list.getLast());

        list.removeLast();
        list.removeTop();
        System.out.printf("First: %d, Last: %d\n", list.getTop(), list.getLast());
    }

    public static DoubleLinkedList<Integer> initList() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        return list;
    }
}
