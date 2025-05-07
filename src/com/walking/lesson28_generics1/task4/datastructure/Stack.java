package com.walking.lesson28_generics1.task4.datastructure;

import com.walking.lesson28_generics1.task4.exception.ElementNotFoundException;

import java.util.Objects;

public class Stack<T> {
    private Node<T> top;
    private int size;

    public int getSize() {
        return size;
    }

    public void push(T value) {
        top = new Node<>(value, top);
        size++;
    }

    public void delete(T value) {
        Node<T> temporary = top;

        if (Objects.equals(value, top.value)) {
            top = top.next;
            size--;

            return;
        }

        delete(value, temporary);
    }

    private void delete(T value, Node<T> element) {
        if (element.next == null) {
            throw new ElementNotFoundException("Element " + value + " not found in stack");
        }

        if (Objects.equals(value, element.next.value)) {
            element.next = element.next.next;
            size--;

            return;
        }

        element = element.next;
        delete(value, element);
    }

    public T find(T value) {
        Node<T> temporary = top;

        while (temporary.next != null) {

            if (Objects.equals(value, temporary.value)) {
                return temporary.value;
            }

            temporary = temporary.next;
        }

        throw new ElementNotFoundException("Element " + value + " not found in stack");
    }

    @Override
    public String toString() {
        Node<T> temporary = top;
        StringBuilder stackToString = new StringBuilder("[");

        while (temporary != null) {
            stackToString.append(temporary.value);

            if (temporary.next != null) {
                stackToString.append(",");
            }

            temporary = temporary.next;
        }

        stackToString.append("]");
        return stackToString.toString();
    }

    public static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
