package com.walking.lesson39_queue1.task2.structure;

import java.util.EmptyStackException;

public class Stack<E> {
    private final LinkedList<E> linkedList;

    public Stack() {
        this.linkedList = new LinkedList<>();
    }

    public void push(E element) {
        linkedList.add(element);
    }

    public E pop() {
        if (linkedList.getSize() == 0) {
            throw new EmptyStackException();
        }

        E top = linkedList.getTop();
        linkedList.delete(top);

        return top;
    }

    public E peek() {
        if (linkedList.getSize() == 0) {
            throw new EmptyStackException();
        }

        return linkedList.getTop();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}