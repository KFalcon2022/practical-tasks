package com.walking.lesson39_queue1.task1.structure;

import com.walking.lesson39_queue1.task1.exception.ElementNotFoundException;

import java.util.*;

public class LinkedList<E> {
    private Node<E> top;
    private int size;

    public LinkedList() {
    }

    public LinkedList(E topValue) {
        this.top = new Node<>(topValue);
        size++;
    }

    public E getTop() {
        if (size == 0) {
            throw new ElementNotFoundException();
        }

        return top.value;
    }

    public int getSize() {
        return size;
    }

    public boolean add(E element) {
        top = new Node<>(element, top);
        size++;

        return true;
    }

    public void delete(Object object) {
        if (top != null) {
            if (Objects.equals(object, top.value)) {
                top = top.next;
                size--;

                return;
            }

            Node<E> current = top;

            while (current.next != null) {
                if (Objects.equals(current.next.value, object)) {
                    current.next = current.next.next;
                    size--;

                    return;
                }

                current = current.next;
            }
        }

        throw new ElementNotFoundException();
    }

    public void deleteAllWithEvenHash() {
        Node<E> current = top;

        while (current != null) {
            if (current.hasEvenHash()) {
                delete(current.value);
            }

            current = current.next;
        }
    }

    public void reverse() {
        if (isReversible()) {
            Node<E> nextTop = null;
            Node<E> previousTop = null;

            while (top.next != null) {
                nextTop = top.next;
                top.next = previousTop;
                previousTop = top;
                top = nextTop;
            }

            top.next = previousTop;
        }
    }

    public void alternativeReverse() {
        if (isReversible()) {
            LinkedList<E> reversed = new LinkedList<>();

            while (top != null) {
                reversed.add(top.value);
                delete(top.value);
            }

            top = reversed.top;
            size = reversed.size;
        }
    }

    private boolean isReversible() {
        return size > 1;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(",", "TOP -> ", " (size = " + size + ")");

        Node<E> current = top;

        while (current != null) {
            result.add(current.value.toString());
            current = current.next;
        }

        return result.toString();
    }

    private static class Node<E> {
        private final E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        private boolean hasEvenHash() {
            return value.hashCode() % 2 == 0;
        }
    }
}