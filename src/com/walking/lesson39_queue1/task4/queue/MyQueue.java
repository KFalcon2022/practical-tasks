package com.walking.lesson39_queue1.task4.queue;

import com.walking.lesson39_queue1.task3.list.MyDoublyLinkedList;

public class MyQueue<E> {
    private final MyDoublyLinkedList<E> list;

    public MyQueue(E el) {
        this.list = new MyDoublyLinkedList<>(el);
    }

    public Object pop() {
        Object value = list.getHeadValue();
        list.removeFirst();
        return value;
    }

    public void push(E el) {
        list.addLast(el);
    }

    public Object peek() {
        return list.getHeadValue();
    }
}
