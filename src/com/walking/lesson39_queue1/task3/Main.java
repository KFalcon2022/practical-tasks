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
        numbs.addFirst(47);
        numbs.addFirst(22);
        numbs.addFirst(56);
        numbs.addFirst(90);
        numbs.addFirst(1);
        numbs.addLast(109);

        System.out.println(numbs);
        numbs.reverse();
        System.out.println(numbs);
    }
}
