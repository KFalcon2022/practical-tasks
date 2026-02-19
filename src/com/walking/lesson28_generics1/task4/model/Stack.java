package com.walking.lesson28_generics1.task4.model;

import com.walking.lesson28_generics1.task4.exception.StackElementNotFoundException;

import java.util.Objects;

public class Stack<T extends Object> {
    private Node<T> top;
    private long size;

    public Stack() {
    }

    public Stack(T top) {
        this.top = new Node<>(top);
        size++;
    }

    public void add(T element) {
        top = new Node<>(element, top);
        size++;
    }

    public void delete(T element) {
        Node<T> temp = top;

        if (Objects.equals(element, top.value)) {
            top = top.next;
            size--;

            return;
        }

        while (temp.next != null) {
            if (Objects.equals(element, top.next.value)) {
                temp.next = temp.next.next;
                size--;

                return;
            }

            throw new StackElementNotFoundException();
        }
    }

    public T find(T element) {
        Node<T> temp = top;

        while (temp != null) {
            if (Objects.equals(element, temp.value)) {
                return temp.value;
            }

            temp = temp.next;
        }

        throw new StackElementNotFoundException();
    }

    public String getSize() {
        return "Size of stack is " + size;
    }

    @Override
    public String toString() {
        StringBuilder toStringValue = new StringBuilder("[");
        Node<T> temp = top;

        while (temp != null) {
            toStringValue.append(temp.value);

            if (temp.next != null) {
                toStringValue.append(", ");
            }

            temp = temp.next;
        }

        toStringValue.append("]");

        return toStringValue.toString();
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
