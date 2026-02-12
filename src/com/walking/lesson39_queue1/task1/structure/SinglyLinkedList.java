package com.walking.lesson39_queue1.task1.structure;

import com.walking.lesson39_queue1.task1.exception.ElementNotFoundException;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private Node<T> top;
    private long size;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(T top) {
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
            if (Objects.equals(element, temp.next.value)) {
                temp.next = temp.next.next;
                size--;

                return;
            }

            temp = temp.next;
        }

        throw new ElementNotFoundException();
    }

    public T find(T element) {
        Node<T> temp = top;

        while (temp != null) {
            if (Objects.equals(element, temp.value)) {
                return temp.value;
            }

            temp = temp.next;
        }

        throw new ElementNotFoundException();
    }

    public long getSize() {
        return size;
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

    public SinglyLinkedList<T> reverseStack() {
        SinglyLinkedList<T> reversSinglyLinkedList = new SinglyLinkedList<>();
        Node<T> temp = top;

        while (temp != null) {
            reversSinglyLinkedList.add(temp.value);
            temp = temp.next;
        }

        return reversSinglyLinkedList;
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
