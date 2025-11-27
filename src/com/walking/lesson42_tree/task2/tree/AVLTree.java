package com.walking.lesson42_tree.task2.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AVLTree<E> {
    private Node<E> root;
    private Comparator<? super E> comparator;

    public AVLTree() {
    }

    public AVLTree(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(E el) {
        if (isEmpty()) {
            root = new Node<>(el);
        } else {
            root = add(el, root);
        }
    }

    public void delete(E el) {
        if (!isEmpty()) {
            delete(el, root);
        }
    }

    public List<E> bypassPreorder() {
        List<E> list = new ArrayList<>();
        bypassPreorder(root, list);
        return list;
    }

    private void bypassPreorder(Node<E> node, List<E> list) {
        list.add(node.value);
        if (node.left != null) {
            bypassPreorder(node.left, list);
        }
        if (node.right != null) {
            bypassPreorder(node.right, list);
        }
    }

    private Node<E> delete(E el, Node<E> node) {
        if (node == null) {
            return null;
        }

        int compareResult = compare(el, node.value);

        if (compareResult > 0) {
            node.right = delete(el, node.right);
        } else if (compareResult < 0) {
            node.left = delete(el, node.left);
        } else {
            Node<E> l = node.left;
            Node<E> r = node.right;
            if (l == null) {
                return r;
            } else if (r == null) {
                return l;
            }
            Node<E> max = findMax(node.left);
            max.left = delete(max.value, node.left);
            max.right = r;
            return balance(max);
        }
        return balance(node);
    }

    private Node<E> findMax(Node<E> node) {
        return (node.right == null) ? node : findMax(node.right);
    }

    private Node<E> add(E el, Node<E> node) {
        if (node == null) {
            return new Node<>(el);
        }
        int compareResult = compare(el, node.value);
        if (compareResult > 0) {
            node.right = add(el, node.right);
        } else {
            node.left = add(el, node.left);
        }
        return balance(node);
    }

    private Node<E> balance(Node<E> node) {
        fixHeight(node);
        if (getBalanceFactor(node) == 2) {
            if (getBalanceFactor(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }

        if (getBalanceFactor(node) == -2) {
            if (getBalanceFactor(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }
        return node;
    }

    private Node<E> rotateRight(Node<E> node) {
        Node<E> node1 = node.left;
        node.left = node1.right;
        node1.right = node;
        fixHeight(node);
        fixHeight(node1);
        return node1;
    }

    private Node<E> rotateLeft(Node<E> node) {
        Node<E> node1 = node.right;
        node.right = node1.left;
        node1.left = node;
        fixHeight(node);
        fixHeight(node1);
        return node1;
    }

    private int getBalanceFactor(Node<E> node) {
        return getHeight(node.left) - getHeight(node.right);
    }

    private void fixHeight(Node<E> node) {
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        node.height = (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
    }

    private int getHeight(Node<E> node) {
        return node == null ? 0 : node.height;
    }

    private int compare(E el1, E el2) {
        return comparator == null
                ? ((Comparable<? super E>) el1).compareTo(el2)
                : comparator.compare(el1, el2);
    }

    private static class Node<E> {
        private E value;
        private int height;
        Node<E> left;
        Node<E> right;

        private Node(E value) {
            this.value = value;
            this.height = 1;
        }
    }
}
