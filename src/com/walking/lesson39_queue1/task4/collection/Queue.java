package com.walking.lesson39_queue1.task4.collection;

import com.walking.lesson39_queue1.collection.DoublyLinkedList;

public class Queue<E> {
    private final DoublyLinkedList<E> list = new DoublyLinkedList<>();

    public void push(E e) {
        list.addLast(e);
    }

    public E pop() {
        E result = list.getTop();
        list.removeTop();

        return result;
    }
}
