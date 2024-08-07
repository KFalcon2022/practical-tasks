package com.walking.lesson28_generics1.task4.structure;

public class Stack<T> {
    private T[] peak;
    private int size;

    public Stack() {

    }

    public Stack(T[] peak) {
        this.peak = peak;
    }

    public void push(T value) {
        this peak = new Node<T>(value);
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
