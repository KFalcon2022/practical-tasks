package com.walking.lesson42_tree.task1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {
    private Node root;

    public Node getRoot() {
        return root;
    }

    private Comparator<T> comparator = null;

    public BinaryTree() {
    }

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Node add(T value) {
        return root = add(root, value);

    }

    public boolean containsNode(T value) {
        return containsNode(root, value);
    }

    public void delete(T value) {
         root = delete(root, value);
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(node.value + " ");
            traverseInOrder(node.right);
        }
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.print(node.value + " ");

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    private Node add(Node node, T value) {
        if (node == null) {
            return new Node(value);
        }

        int result;

        if (comparator != null) {
            result = comparator.compare(value, node.value);
        } else {
            result = value.compareTo(node.value);
        }

        if (result <= 0) {
            node.left = add(node.left, value);
        }

        if (result > 0) {
            node.right = add(node.right, value);
        }

        return node;
    }

    private boolean containsNode(Node node, T value) {
        if (node == null) {
            return false;
        }

        if (node.value == value) {
            return true;
        }

        int result = value.compareTo(node.value);

        return result < 0
                ? containsNode(node.left, value)
                : containsNode(node.right, value);

    }

    private Node delete(Node node, T value) {
        if (node == null) {
            return null;
        }

        int result = value.compareTo(node.value);

        if (result == 0) {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.right == null) {
                return node.left;
            }

            if (node.left == null) {
                return node.right;
            }

            T smallestValue = findSmallestValue(node.right);
            node.value = smallestValue;
            node.right = delete(node.right, smallestValue);
            return node;
        }

        if (result < 0) {
            node.left = delete(node.left, value);
            return node;
        }

        node.right = delete(node.right, value);

        return node;
    }

    private T findSmallestValue(Node node) {
        return node.left == null ? node.value : findSmallestValue(node.left);
    }

    class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
