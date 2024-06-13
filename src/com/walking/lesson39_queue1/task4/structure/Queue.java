package com.walking.lesson39_queue1.task4.structure;

import java.util.EmptyStackException;

public class Queue<E> {
    private final LinkedList<E> linkedList;

    public Queue() {
        this.linkedList = new LinkedList<>();
    }

    public void push(E element) {
        linkedList.addLast(element);
    }

    public E pop() {
        if (linkedList.isEmpty()) {
            throw new EmptyStackException();
        }

        return linkedList.removeFirst();
    }

    public E peek() {
        if (linkedList.isEmpty()) {
            throw new EmptyStackException();
        }

        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}