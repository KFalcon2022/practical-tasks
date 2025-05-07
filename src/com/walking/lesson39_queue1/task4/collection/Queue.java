package com.walking.lesson39_queue1.task4.collection;

import com.walking.lesson39_queue1.collection.DoubleLinkedList;

public class Queue<T> {
    private final DoubleLinkedList<T> list = new DoubleLinkedList();

    public void push(T elem) {
        list.add(elem);
    }

    public T pop() {
        T elem = list.getTop();
        list.removeTop();
        return elem;
    }
}
