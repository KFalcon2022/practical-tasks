package com.walking.lesson39_queue1.task4;

import com.walking.lesson39_queue1.task3.DoubleLinkedList;

public class SingleQueue<E> {
    private final DoubleLinkedList<E> list = new DoubleLinkedList<>();

    public E pop() {
        E result = list.getFirst();
        list.remove(result);

        return result;
    }

    public void push(E e) {
        list.addLast(e);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
