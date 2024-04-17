package com.walking.lesson39_queue1.task2.collection;

import com.walking.lesson39_queue1.collection.SinglyLinkedList;

public class Stack<T> {
    private final SinglyLinkedList<T> list = new SinglyLinkedList<>();

    public void push(T elem) {
        list.add(elem);
    }

    public T pop() {
        T top = list.getTop();
        list.remove(top);

        return top;
    }

    public T peek() {
        return list.getTop();
    }
}
