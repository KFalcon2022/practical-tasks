package com.walking.lesson39_queue1.task4;

import com.walking.lesson39_queue1.collection.DoublyLinkedList;
import com.walking.lesson39_queue1.task4.collection.Queue;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;

/**
 * Реализуйте одностороннюю очередь на базе двусвязного списка из Задачи 3.
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> integerQueue = new Queue<>();
        integerQueue.push(10);

        while (integerQueue != null) {
            System.out.println(integerQueue.pop());
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
