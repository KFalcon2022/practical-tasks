package com.walking.lesson39_queue1.task2.structure;

import com.walking.lesson39_queue1.task2.exception.ElementNotFoundException;

import java.util.Objects;
import java.util.StringJoiner;

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
            if (Objects.equals(top.value, object)) {
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
    }
}