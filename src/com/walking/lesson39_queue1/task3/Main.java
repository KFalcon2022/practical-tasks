package com.walking.lesson39_queue1.task3;

import com.walking.lesson39_queue1.collection.DoublyLinkedList;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;

/**
 * Реализуйте двусвязный список.
 * Реализуйте метод, разворачивающий список.
 * Также реализуйте метод, удаляющий все узлы, хэшкод элемента которых - четный.
 */
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> testIntegerList = new DoublyLinkedList<>();

        testIntegerList.add(1);
        testIntegerList.add(2);
        testIntegerList.add(4);
        testIntegerList.add(6);

        testIntegerList.addTop(3);

//        testIntegerList.reverse();

        for (Integer i : testIntegerList) {
            System.out.println(i);
        }
    }

    private static @NotNull DoublyLinkedList<Integer> createIntegerList() {
        DoublyLinkedList<Integer> testIntegerList = new DoublyLinkedList<>();
        testIntegerList.add(1);
        testIntegerList.add(2);
        testIntegerList.add(3);
        testIntegerList.add(4);
        testIntegerList.add(5);
        testIntegerList.add(6);
        testIntegerList.add(7);

        return testIntegerList;
    }

    private static <E> void dropEvenHashCodeElement(Collection<E> c) {
        Iterator<E> iterator = c.iterator();

        while (iterator.hasNext()) {
            E e = iterator.next();

            if (e.hashCode() % 2 == 0) {
                c.remove(e);
            }
        }
    }
}
