package com.walking.lesson39_queue1.task2.collection;

import com.walking.lesson39_queue1.collection.SinglyLinkedList;

public class Stack<E> {
    private final SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public void push(E e) {
        list.add(e);
    }

    public E pop() {
        E result = list.getTop();
        list.remove(result);

        return result;
    }
}
