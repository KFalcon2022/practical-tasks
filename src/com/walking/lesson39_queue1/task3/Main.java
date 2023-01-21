package com.walking.lesson39_queue1.task3;

import com.walking.lesson39_queue1.collection.DoublyLinkedList;
import com.walking.lesson39_queue1.util.CollectionUtils;

/**
 * Реализуйте двусвязный список.
 * Реализуйте метод, разворачивающий список.
 * Также реализуйте метод, удаляющий все узлы, хэшкод элемента которых - четный.
 */
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addTop(3);
        list.addLast(4);
        list.addTop(5);
        list.addTop(6);
        list.addTop(7);

        System.out.printf("first: %d; last: %d\n", list.getTop(), list.getLast());
        list.reverse();
        System.out.printf("first: %d; last: %d\n", list.getTop(), list.getLast());

        list.removeLast();
        list.removeTop();
        System.out.printf("first: %d; last: %d\n", list.getTop(), list.getLast());

        System.out.println(list.size());
        CollectionUtils.dropEvenHashCodeElements(list);
        System.out.println(list.size());
    }
}
