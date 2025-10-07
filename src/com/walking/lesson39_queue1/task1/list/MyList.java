package com.walking.lesson39_queue1.task1.list;

import com.walking.lesson39_queue1.task1.exception.ListIsEmptyException;

public class MyList<E> {
    private Node<E> tail;
    int size;

    public MyList() {
    }

    public MyList(E top) {
        this.tail = new Node<>(top);
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean find(Object o) {
        Node<E> el = tail;

        while (el != null) {
            if (o.equals(el.value)) {
                return true;
            }
            el = el.previous;
        }
        return false;
    }

    public void add(E el) {
        tail = new Node<>(tail, el);
        size++;
    }

    public void remove(Object o) {
        if (isEmpty()) {
            throw new ListIsEmptyException("Список пуст.");
        }

        if (o.equals(tail.value)) {
            tail = tail.previous;
            size--;
        }

        Node<E> el = tail;
        while (el.previous != null) {
            if (o.equals(el.previous.value)) {
                el.previous = el.previous.previous;
                size--;
            }
            el = el.previous;
        }
    }

    public String toString() {
        StringBuilder allElements = new StringBuilder();
        Node<E> el = tail;

        while (el != null) {
            allElements.append(el.value);
            if (el.previous != null) {
                allElements.append(", ");
            }
            el = el.previous;
        }
        return allElements.toString();
    }

    public void reverse() {
        Node<E> prev = null;
        Node<E> top = tail;

        while (top != null) {
            Node<E> newTail = top.previous;
            top.previous = prev;
            prev = top;
            top = newTail;
        }

        tail = prev;
    }

    public void removeEvenHashCodes() {
        while (!isEmpty() && tail.hashCode() % 2 == 0) {
            tail = tail.previous;
            size--;
        }

        Node<E> current = tail;
        while (current.previous != null) {
            if (current.previous.hashCode() % 2 == 0) {
                current.previous = current.previous.previous;
                size--;
            } else {
                current = current.previous;
            }
        }
    }

    public Object getTailValue() {
        return tail.value;
    }

    private static class Node<E> {
        private final E value;
        private Node<E> previous;

        private Node(E value) {
            this.value = value;
        }

        private Node(Node<E> previous, E value) {
            this.value = value;
            this.previous = previous;
        }
    }
}
