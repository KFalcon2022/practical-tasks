package com.walking.lesson28_generics1.task4;

public class Stack<T> {
    private int size = 0;
    private Node<T> first;

    public Stack() {
        first = null;
    }

    public int getSize() {
        return size;
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        Node<T> tempNode = first;

        if (first == null) {
            first = newNode;
        } else {
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        size++;
    }

    public T search(T element) {
        Node<T> tempNode = first;

        while (tempNode.next != null) {
            if (tempNode.value.equals(element)) {
                return element;
            }
            tempNode = tempNode.next;
        }

        if (tempNode.value.equals(element)) {
            return element;
        }

        throw new StackElementNotFoundException();
    }

    public void delete(T element) {
        Node<T> tempNode = first;
        Node<T> previousNode = null;

        while (tempNode.next != null) {
            if (tempNode.value.equals(element)) {
                if (tempNode == first) {
                    first = tempNode.next;
                } else {
                    previousNode.next = tempNode.next;
                }
                size--;
                return;
            }
            previousNode = tempNode;
            tempNode = tempNode.next;
        }
        throw new StackElementNotFoundException();
    }

    @Override
    public String toString() {
        StringBuilder arrayStackElements = new StringBuilder("[");
        Node<T> tempNode = first;

        while (tempNode.next != null) {
            arrayStackElements.append(tempNode.value + ", ");
            tempNode = tempNode.next;
        }
        arrayStackElements.append(tempNode.value);
        arrayStackElements.append("]");

        return arrayStackElements.toString();
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}

