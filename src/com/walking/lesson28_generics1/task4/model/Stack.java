package com.walking.lesson28_generics1.task4.model;

import java.util.Objects;

public class Stack <T>{
    private Node top;
    private int size;

    public Stack (T value) {
        top = new Node(value);
        size++;
    }

    public void push (T value) {
        Node temp = top;
        top = new Node<>(value);
        top.next = temp;
        size++;
    }

    public int getSize() {
        return size;
    }

    public void deleteElement(T element) {
        Node<T> temp = top;

        if (Objects.equals(element, top.item)) {
            top = top.next;
            size--;

            return;
        }

        while (temp.next != null) {
            if (Objects.equals(element, temp.next.item)) {
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }

        throw new ExceptionNotFound();
    }

    public T searchElement(T element) {
        Node<T> temp = top;

        if (Objects.equals(element, top.item)) {
            return element;
        }

        while (temp.next != null) {
            if (Objects.equals(element, temp.next.item)) {
                return element;
            }
            temp = temp.next;
        }

        throw new ExceptionNotFound();
    }

    @Override
    public String toString() {
        Node temp = top;
        StringBuilder result = new StringBuilder();
        result.append("[");

        for (int i = 0; i < size - 1; i++) {
            result.append(temp.item +", ");
            temp = temp.next;
        }

        result.append(temp.item + "]");

        return result.toString();
    }

    private class Node <T>{
        T item;
        Node next;

        private Node (T value) {
            this.item = value;
        }
    }
}
