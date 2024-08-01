package com.walking.lesson42_tree.task2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class AvlTree<T extends Comparable<T>> {
    private Node root;

    public Node getRoot() {
        return root;
    }

    private Comparator<T> comparator;

    public AvlTree() {
    }

    public AvlTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Node add(T value) {
        root = add(root, value);
        System.out.println("Node " + value + " added to AVL tree!");

        return root;
    }

    public boolean containsNode(T value) {
        return containsNode(root, value);
    }

    public void delete(T value) {
         root = delete(root, value);
        System.out.println("Node " + value + " has been removed from the AVL tree.");
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

        return balance(node);
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

        return balance(node);
    }

    private T findSmallestValue(Node node) {
        return node.left == null ? node.value : findSmallestValue(node.left);
    }

    private int getHeight(Node node) {
        return node == null ? -1 : node.height;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : (getHeight(node.right) - getHeight(node.left));
    }

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private Node rotateRight(Node root) {
        Node node = root.left;
        Node leaf = node.right;

        node.right = root;
        root.left = leaf;

        updateHeight(root);
        updateHeight(node);

        return node;
    }

    private Node rotateLeft(Node root) {
        Node node = root.right;
        Node leaf = node.left;

        node.left = root;
        root.right = leaf;

        updateHeight(root);
        updateHeight(node);

        return node;
    }

    private Node balance(Node node) {
        updateHeight(node);

        int balance = getBalance(node);

        if (balance > 1) {
            if (getHeight(node.right.right) > getHeight(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        else if (balance < -1) {
            if (getHeight(node.left.left) > getHeight(node.left.right)) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }

        return node;
    }

    class Node {
        private int height;
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
