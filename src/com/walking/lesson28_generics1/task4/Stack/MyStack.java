package com.walking.lesson28_generics1.task4.Stack;

import java.util.Arrays;

public class MyStack<T> {

    private Node<T> head;
    private int size;


    @Override
    public String toString() {
        String[] array = new String[size];
        Node<T> currentNode = head;
        for (int i = 0; i < array.length; i++) {
            array[i] = currentNode.value.toString();
            currentNode = currentNode.next;
        }
        return Arrays.toString(array);
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }
    }

    private int increaseSize() {
        return size++;
    }

    private int decreaseSize() {
        return size--;
    }


    public void add(T t) {
        Node<T> node = new Node<>(t);
        node.next = head;
        head = node;
        increaseSize();
    }

    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        head = head.next;
        decreaseSize();

    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
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


}
