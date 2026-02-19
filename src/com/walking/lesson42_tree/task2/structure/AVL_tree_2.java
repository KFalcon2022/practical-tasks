package com.walking.lesson42_tree.task2.structure;

import java.util.Comparator;

/// да, это версия с ютюба. Немного отредактирована, т.к. при удалении корневого значения не находил его.
public class AVL_tree_2<E> {
    private Node<E> root;
    private Comparator<E> comparator;

    public AVL_tree_2() {
    }

    public AVL_tree_2(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    private boolean isEmpty() {
        return root == null;
    }

    public void add(E value) {
        if (isEmpty()) {
            root = new Node<>(value);
            return;
        }

        add(value, root);
        System.out.printf("Element '%s' added\n", value.toString());
        balance(root);
    }

    private void add(E value, Node<E> node) {
        if (compare(value, node.value) > 0) {
            if (node.right == null) {
                node.right = new Node<>(value);
            } else {
                add(value, node.right);
            }
        } else {
            if (node.left == null) {
                node.left = new Node<>(value);
            } else {
                add(value, node.left);
            }
        }

        updateHeight(node);
        balance(node);
    }

    private Node<E> search(E value) {
        if (isEmpty()) {
            throw new RuntimeException("Root is empty");
        }

        if (compare(value, root.value) == 0) {
            return root;
        }

        return (compare(value, root.value) > 0)
                ? search(value, root.right)
                : search(value, root.left);
    }

    private Node<E> search(E value, Node<E> node) {
        if (node == null) {
            throw new RuntimeException("Element not found!");
        }

        int difference = compare(value, node.value);
        if (difference == 0) {
            return node;
        }

        return difference > 0
                ? search(value, node.right)
                : search(value, node.left);
    }

    private Node<E> getMin(Node<E> node) {
        if (node == null) {
            throw new RuntimeException("Node is empty");
        }

        if (node.left == null) {
            return node;
        }

        return getMin(node.left);
    }

    private Node<E> getMax(Node<E> node) {
        if (node == null) {
            throw new RuntimeException("Node is empty");
        }

        if (node.right == null) {
            return node;
        }

        return getMax(node.right);
    }

    public void delete(E value) {
        if (isEmpty()) {
            throw new RuntimeException("Root is empty");
        }

        Node<E> removedNode = delete(value, root);
        System.out.printf("Element '%s' deleted\n", removedNode.value.toString());
    }

    private Node<E> delete(E value, Node<E> node) {
        if (node == null) {
            throw new RuntimeException("Element not found!");
        } else if (node.left == null && node.right == null) {
            return null;
        } else if (compare(value, node.value) == 0) {
            if (node.right == null || node.left == null) {
                node = node.right == null ? node.left : node.right;
            } else {
                Node<E> maxInLeft = getMax(node.left);
                node.value = maxInLeft.value;
                node.left = delete(value, node.left);
            }
        } else if (compare(value, node.value) > 0) {
            node.right = delete(value, node.right);
        } else {
            node.left = delete(value, node.left);
        }

        if (node != null) {
            updateHeight(node);
            balance(node);
        }
        return node;
    }

    private int getHeight(Node<E> node) {
        return node == null ? -1 : node.height;
    }

    public int getTreeHeight() {
        return getHeight(root) + 1;
    }

    private void updateHeight(Node<E> node) {
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private int getBalance(Node<E> node) {
        return node == null ? -1 : getHeight(node.right) - getHeight(node.left);
    }

    private void swap(Node<E> n1, Node<E> n2) {
        E n1_value = n1.value;
        n1.value = n2.value;
        n2.value = n1_value;
    }

    private void rightRotate(Node<E> node) {
        swap(node, node.left);
        Node<E> temp = node.right;
        node.right = node.left;
        node.left = node.right.left;
        node.right.left = node.right.right;
        node.right.right = temp;
        updateHeight(node.right);
        updateHeight(node.left);
        updateHeight(node);
    }

    private void leftRotate(Node<E> node) {
        swap(node, node.right);
        Node<E> temp = node.left;
        node.left = node.right;
        node.right = node.left.right;
        node.left.right = node.left.left;
        node.left.left = temp;
        updateHeight(node.left);
        updateHeight(node.right);
        updateHeight(node);
    }

    private void balance(Node<E> node) {
        int balance = getBalance(node);
        if (balance == -2) {
            if (getBalance(node.left) == 1) {
                leftRotate(node.left);
            }
            rightRotate(node);
        }

        if (balance == 2) {
            if (getBalance(node.right) == -1) {
                rightRotate(node.right);
            }
            leftRotate(node);
        }
    }

    private int compare(E o1, E o2) {
        return comparator == null
                ? ((Comparable<? super E>) o1).compareTo(o2)
                : comparator.compare(o1, o2);
    }

    private static class Node<E> {
        private E value;
        private Node<E> left;
        private Node<E> right;
        private int height = 0;

        public Node(E value) {
            this(value, null, null);
        }

        public Node(E value, Node<E> left, Node<E> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
