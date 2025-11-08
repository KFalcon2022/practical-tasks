package com.walking.lesson42_tree.task1.tree;

import java.util.*;

public class BinaryTree<E> {
    private Node<E> root;
    private Comparator<? super E> comparator;

    public BinaryTree() {

    }

    public BinaryTree(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public E add(E el) {
        if (isEmpty()) {
            compare(el, el);
            root = new Node<>(el);
        } else {
            add(el, root);
        }
        return el;
    }

    public E delete(E el) {
        if (isEmpty()) {
            return null;
        } else {
            delete(el, root);
            return el;
        }
    }

    public List<E> searchPreorder() {
        List<E> list = new ArrayList<>();
        searchPreorder(root, list);
        return list;
    }

    public List<E> searchBreadthFirst() {
        List<E> list = new ArrayList<>();
        Queue<Node<E>> queue = new ArrayDeque<>();
        queue.add(root);
        searchBreadthFirst(list, queue);

        return list;
    }

    private void searchBreadthFirst(List<E> list, Queue<Node<E>> queue) {
        while (!queue.isEmpty()) {
            for (Node<E> node : queue) {
                list.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                queue.remove();
            }
        }
    }

    public void balance() {
        List<E> list = searchPreorder();
        list.sort(comparator == null ? (Comparator<? super E>) Comparator.naturalOrder() : comparator);

        int middle = list.size() / 2;
        root = new Node<>(list.get(middle));
        balance(list, middle, list.size());
        balance(list, -1, middle);
    }

    private void balance(List<E> list, int low, int high) {
        int middleIndex = high - ((high - low) / 2);
        add(list.get(middleIndex));

        if (middleIndex - low > 1) {
            balance(list, low, middleIndex);
        }
        if (high - middleIndex > 1) {
            balance(list, middleIndex, high);
        }
    }

    private void searchPreorder(Node<E> node, List<E> list) {
        list.add(node.value);
        if (node.left != null) {
            searchPreorder(node.left, list);
        }
        if (node.right != null) {
            searchPreorder(node.right, list);
        }
    }

    private Node<E> add(E el, Node<E> node) {
        int compareResult = compare(el, node.value);

        if (compareResult > 0) {
            return node.right == null ? node.right = new Node<>(el, node) : add(el, node.right);
        } else {
            return node.left == null ? node.left = new Node<>(el, node) : add(el, node.left);
        }
    }

    private Node<E> delete(E el, Node<E> node) {
        int compareResult = compare(el, node.value);
        Node<E> result = node;

        if (compareResult > 0) {
            node.right = delete(el, node.right);
        } else if (compareResult < 0) {
            node.left = delete(el, node.left);
        } else {
            if (node.right != null && node.left != null) {
                Node<E> max = findMax(node.left);
                node.value = max.value;
                delete(max.value, max.parent);
            } else if (node.left != null) {
                result = node.left.parent = node.parent;
            } else if (node.right != null) {
                result = node.right.parent = node.parent;
            } else {
                result = null;
            }
        }
        return result;
    }

    private Node<E> findMax(Node<E> node) {
        if (node.right == null) {
            return node;
        } else {
            return findMax(node.right);
        }
    }

    private int compare(E el1, E el2) {
        return comparator == null
                ? ((Comparable<? super E>) el1).compareTo(el2)
                : comparator.compare(el1, el2);
    }

    public E getRootValue() {
        return root.value;
    }

    private static class Node<E> {
        private E value;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        private Node(E value) {
            this.value = value;
        }

        private Node(E value, Node<E> parent) {
            this.value = value;
            this.parent = parent;
        }
    }
}
