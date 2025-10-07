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
        numbs.addHead(24);
        numbs.addHead(47);
        numbs.addHead(22);
        numbs.addHead(56);
        numbs.addHead(90);
        numbs.addHead(1);
        numbs.addTail(109);

        System.out.println(numbs);
        numbs.reverse();
        System.out.println(numbs);
    }
}
