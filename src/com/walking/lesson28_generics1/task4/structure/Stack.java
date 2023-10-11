package com.walking.lesson28_generics1.task4.structure;

public class Stack<T> {
    private Node<T> top;
    private long size;

    Stack() {

    }
    Stack(T elem) {
        this.top = new Node<>(elem);
        size++;
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
