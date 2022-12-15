package com.walking.lesson28_generics_1.task_4;

import java.util.StringJoiner;

public class CustomList<T> {
    private Node<T> rootNode;
    private int size = 0;

    public void add(T value) {
        if (rootNode == null) {
            rootNode = new Node<>(value);
        } else {
            getLast().setNextNode(new Node<>(value));
        }

        size++;
    }

    public void delete(T value) {
        Node<T> delNode = findNodeByValue(value);
        Node<T> prevNode = getPreviousNode(delNode);
        Node<T> nextNode = delNode.getNextNode();

        if (delNode.equals(rootNode)) {
            rootNode = rootNode.getNextNode();
        } else {
            prevNode.setNextNode(nextNode);
        }

        size--;
    }

    public int size() {
        return this.size;
    }

    public T find(T value) {
        if (rootNode == null) {
            throw new RuntimeException("List is empty");
        }
        return findNodeByValue(value).getValue();
    }

    @Override
    public String toString() {
        if (rootNode == null) {
            return "[...]";
        }

        StringJoiner joiner = new StringJoiner(", ");
        Node<T> current = rootNode;

        while (true) {
            joiner.add(current.getValue().toString());
            if (current.isLast()) {
                return "[%s]".formatted(joiner);
            }
            current = current.getNextNode();
        }
    }

    private Node<T> getLast() {
        Node<T> current = rootNode;
        while (!current.isLast()) {
            current = current.nextNode;
        }
        return current;
    }

    private Node<T> findNodeByValue(T targetValue) {
        Node<T> current = rootNode;
        while (true) {
            if (current.getValue() == targetValue) { // matching objects by link
                return current;
            }
            if (current.isLast()) {
                throw new RuntimeException("Value not exist");
            }
            current = current.getNextNode();
        }
    }

    private Node<T> getPreviousNode(Node<T> targetNode) {
        Node<T> current = rootNode;
        while (!current.isLast()) {
            if (current.getNextNode().equals(targetNode)) {
                return current;
            }
            current = current.getNextNode();
        }
        return null;
    }

    private static class Node<T> {
        final T value;
        Node<T> nextNode;

        Node(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }

        Node<T> getNextNode() {
            return nextNode;
        }

        void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        boolean isLast() {
            return nextNode == null;
        }
    }
}
