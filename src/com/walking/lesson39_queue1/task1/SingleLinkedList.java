package com.walking.lesson39_queue1.task1;

import java.util.Arrays;
import java.util.Objects;

public class SingleLinkedList<T> {

    private Node<T> head;
    private int size;

    public void add(T t) {
        Node<T> node = new Node<>(t);
        node.next = head;
        head = node;
        increaseSize();
    }

    public T get() {
        return head.value;
    }

    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        }
        head = head.next;
        decreaseSize();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T findElement(T t) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value.equals(t)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        throw new RuntimeException("Element not found!");
    }

    public void reverseList() {
        Node<T> current = head.next;
        head.next = null;

        while (current != null) {
            Node<T> next = current.next;
            current.next = head;
            head = current;
            current = next;
        }
    }

    public void deleteNodeWithEvenHash() {
        Node<T> current = head;

        while (current != null) {
            if (current.hashCode() % 2 == 0) {
                current = current.next;
                decreaseSize();

            } else if (current.next.hashCode() % 2 == 0) {
                current.next = current.next.next;
                current = current.next;
                decreaseSize();

            } else {
                current = current.next;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleLinkedList<?> myStack = (SingleLinkedList<?>) o;
        return Objects.equals(head, myStack.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }

    @Override
    public String toString() {
        String[] array = new String[size];
        Node<T> currentNode = head;
        for (int i = 0; i < array.length; i++) {
            array[i] = currentNode.value.toString() + " " + currentNode.hashCode();
            currentNode = currentNode.next;
        }
        return Arrays.toString(array);
    }

    private int increaseSize() {
        return size++;
    }

    private int decreaseSize() {
        return size--;
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }
    }
}
