package com.walking.lesson28_generics1.task4.structure;

import com.walking.lesson28_generics1.task4.exception.NoElement;

public class Stack<T> {
    private Node<T> top;
    private int size;

    public Stack() {

    }
    public Stack(T elem) {
        this.top = new Node<>(elem);
        size++;
    }

    public void add(T elem) {
        top = new Node<>(elem, top);
        size++;
    }

    public T find(T elem) {
        Node<T> temp = top;

        while (temp != null) {
            if (elem.equals(temp.value)) {
                return elem;
            }
            temp = temp.next;
        }

        throw new NoElement();
    }

    public void delete(T elem) {
        Node<T> temp = top;

        if (elem.equals(top.value)) {
            top = top.next;
            size--;

            return;
        }

        while (temp.next != null) {
            if (elem.equals(temp.next.value)) {
                temp.next = temp.next.next;
                size--;

                return;
            }

            temp = temp.next;
        }

        throw new NoElement();
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> temp = top;

        while (temp != null) {
            sb.append(temp.value);

            if (temp.next != null) {
                sb.append(", ");
            }

            temp = temp.next;
        }

        sb.append("]");
        return sb.toString();
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
