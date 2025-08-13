package com.walking.lesson42_tree.task2.model;

import java.util.Comparator;

public class ABLTree<T> {
    private final Comparator comparator;
    private Node<T> rootNode;
    private int size = 0;

    public ABLTree() {
        this.comparator = null;
    }

    public ABLTree(Comparator comparator) {
        this.comparator = comparator;
    }

    public Node<T> getRootNode() {
        return rootNode;
    }

    public int getSize() {
        return size;
    }



    private int compare(T o1, T o2) {
        return comparator == null
                ? ((Comparable<T>) o1).compareTo(o2)
                : comparator.compare(o1, o2);
    }

    private class Node<T> {
        private Node<T> left;
        private T value;
        private Node<T> right;
        private Node<T> parent;

        private Node(T value) {
            this.value = value;
        }

        public Node(Node<T> left, T value, Node<T> right, Node<T> parent) {
            this.left = left;
            this.value = value;
            this.right = right;
            this.parent = parent;
        }
    }
}
