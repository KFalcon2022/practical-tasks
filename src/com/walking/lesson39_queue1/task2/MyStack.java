package com.walking.lesson39_queue1.task2;

import com.walking.lesson39_queue1.task1.SingleLinkedList;

public class MyStack<T>  {
    private final SingleLinkedList<T> list = new SingleLinkedList<>();

    public void push(T t) {
        list.add(t);
    }

    public T pop() {
        T result = list.get();
        list.remove();

        return result;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
