package com.walking.lesson42_tree.task1.structure;

import java.util.*;

public class Tree<T> {
    private Node<T> root;

    private Comparator<T> comparator;

    public Tree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Tree() {

    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(T element) {
        root = add(element, root);

    }

    private Node<T> add(T element, Node<T> node) {
        if (node == null) {
            return new Node<>(element);
        }

        if (compare(element, node.value) <= 0) {
            node.left = add(element, node.left);
        } else {
            node.right = add(element, node.right);
        }

        return node;
    }

    public void remove(T element) {
        remove(element, root);

    }

    private Node<T> remove(T element, Node<T> node) {
        if (node == null) {
            return null;
        }

        Node<T> result = node;
        int compareResult = compare(element, node.value);

        if (compareResult < 0) {
            node.left = remove(element, node.left);
        } else if (compareResult > 0) {
            node.right = remove(element, node.right);
        } else if (node.left != null && node.right != null) {
            node.value = findMax(node.left).value;
            node.left = remove(node.value, node.left);
        } else {
            result = node.left != null ? node.left : node.right;
        }

        return result;

    }


    public void bypassDepth() {
        List<T> result = bypassDepth(root, new ArrayList<>());
        System.out.println(result);
    }

    public void bypassBreadth() {
        Queue<Node<T>> nodes = new ArrayDeque<>();
        nodes.offer(root);

        System.out.print("[");

        while (!nodes.isEmpty()) {
            Node<T> node = nodes.poll();

            System.out.print(node.value);
            if (node.left != null) {
                nodes.offer(node.left);
            }
            if (node.right != null) {
                nodes.offer(node.right);
            }

            if (!nodes.isEmpty()) {
                System.out.print(", ");
            }
        }

        System.out.print("]\n");
    }

    private List<T> bypassDepth(Node<T> node, List<T> resultList) {
        if (node == null) {
            return resultList;
        }

        resultList.add(node.value);

        bypassDepth(node.left, resultList);
        bypassDepth(node.right, resultList);

        return resultList;
    }

    private Node<T> findMax(Node<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        }
        return findMax(node.right);
    }

    private int compare(T o1, T o2) {
        return comparator == null
                ? ((Comparable<? super T>) o1).compareTo((o2))
                : comparator.compare(o1, o2);
    }


    private static class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this(value, null, null);
        }

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public T getValue() {
            return value;
        }

    }
}

