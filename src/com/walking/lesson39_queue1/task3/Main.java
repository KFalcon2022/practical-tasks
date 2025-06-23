package com.walking.lesson39_queue1.task3;

import com.walking.lesson39_queue1.task3.structure.LinkedList;

/**
 * Реализуйте двусвязный список.
 * Реализуйте метод, разворачивающий список.
 * Также реализуйте метод, удаляющий все узлы, хэшкод элемента которых - четный.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();

        System.out.println(integers);

        integers.addFirst(4);
        integers.addFirst(5);
        integers.addFirst(6);
        integers.addLast(3);
        integers.addLast(2);
        integers.addLast(1);

        System.out.println(integers);

        integers.reverse();

        System.out.println(integers);

        System.out.println(integers.removeFirst());
        System.out.println(integers.removeFirst());
        System.out.println(integers.removeFirst());

        System.out.println(integers);

        System.out.println(integers.removeLast());
        System.out.println(integers.removeLast());
        System.out.println(integers.removeLast());

        System.out.println(integers);

        integers.addLast(1);
        integers.addLast(2);
        integers.addLast(3);
        integers.addLast(4);

        integers.reverse();

        System.out.println(integers);

        integers.deleteAllWithEvenHash();

        System.out.println(integers);
    }
}