package com.walking.lesson39_queue1.task3;

import com.walking.lesson39_queue1.task3.list.MyDoublyLinkedList;

/**
 * Реализуйте двусвязный список.
 * Реализуйте метод, разворачивающий список.
 * Также реализуйте метод, удаляющий все узлы, хэшкод элемента которых - четный.
 */
public class Main {
    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> numbs = new MyDoublyLinkedList<>();
        numbs.addFirst(24);
        numbs.addFirst(24);
        numbs.addFirst(24);
        numbs.addFirst(24);
        numbs.addFirst(24);
        numbs.addFirst(24);
        numbs.addFirst(3);

        System.out.println(numbs);
        numbs.removeAll(24);
        System.out.println(numbs);
    }
}
