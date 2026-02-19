package com.walking.lesson42_tree.task2.structure;

import java.util.Comparator;

public class AVL_Tree<E> {
    private Node<E> root;
    private int treeLvl = 0;
    private Comparator<E> comparator;

    public AVL_Tree() {
    }

    public AVL_Tree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void clear() {
        root = null;
        treeLvl = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getLvl() {
        return Math.abs(treeLvl) + 1;
    }

    private void incrementTreeLvl() {
        if (Math.pow(2, Node.count) > Math.pow(2, getLvl())) {
            ++treeLvl;
        }
    }

//    private boolean isBalance(Node<E> node) {
//        if (Math.abs((treeLvl - Node.count)) == 0) {
//            return false;
//        }
//        int left = node.left == null ? 0 : 1;
//        int right = node.right == null ? 0 : 1;
//
//        if (left == 0 || right == 0) {
//            if (Math.abs(left - right) > 1) {
//                return true;
//            }
//
//
//        }
//        return isBalance(node.parent);
//    }

//    private boolean isBalance

    public void add(E value) {
        if (root == null) {
            root = new Node<>(value);
            ++treeLvl;

            return;
        }
        Node.count = 1;
        add(value, root);
        Node.count = 0;
    }

    private void add(E value, Node<E> node) {
        if (compare(value, node.value) > 0) {
            if (node.right == null) {
                node.right = new Node<>(value);
                ++Node.count;
                incrementTreeLvl();

                Node.count = 0;
                return;
            }

            ++Node.count;
            add(value, node.right);
            return;
        }

        if (node.left == null) {
            node.left = new Node<>(value);
            ++Node.count;
            incrementTreeLvl();

            Node.count = 0;
            return;
        }

        ++Node.count;
        add(value, node.left);
    }

    private Node<E> find(E value) {
        if (isEmpty()) {
            throw new RuntimeException("Root is empty");
        }

        return find(value, root);
    }

    private Node<E> find(E value, Node<E> node) {
        if (compare(value, node.value) == 0) {
            return node;
        }

        return compare(value, node.value) > 0
                ? find(value, node.right)
                : find(value, node.left);
    }

    private boolean isHasLeft(Node<E> node) {
        return node.left != null;
    }

    private boolean isHasRight(Node<E> node) {
        return node.right != null;
    }

    private boolean isHasLeftAndRight(Node<E> node) {
        return isHasLeft(node) && isHasRight(node);
    }

    private E getMax() {
        if (isEmpty()) {
            throw new RuntimeException("Root is empty");
        }

        return getMax(root);
    }

    private E getMax(Node<E> node) {
        if (node.right == null) {
            return node.value;
        }

        return getMax(node.right);
    }

    public E getMin() {
        if (isEmpty()) {
            throw new RuntimeException("Root is empty");
        }

        return getMin(root);
    }

    private E getMin(Node<E> node) {
        if (node.left == null) {
            return node.value;
        }

        return getMin(node.left);
    }

    public E delete(E value) {
        if (isEmpty()) {
            throw new RuntimeException("Root is empty");
        }

        Node<E> removedNode = find(value);
        return delete(removedNode);
    }

    private E delete(Node<E> removedNode) {
        E removed = removedNode.value;
        if (removedNode.parent == null) {
            removedNode.value = null;
            treeLvl--;
            return removed;
        }

        if (isHasLeftAndRight(removedNode.parent)) {
            removedNode.value = delete(getMax(removedNode));
        } else if (isHasLeft(removedNode.parent)) {
            removedNode.parent.left = removedNode.left;
        } else if (isHasRight(removedNode.parent)) {
            removedNode.parent.right = removedNode.right;
        } else {
            removedNode.value = null;
        }

        return removed;
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

        private Node<E> parent;
        private static int count = 0;

        public Node(E value) {
            this(value, null, null, null);
        }

        public Node(E value, Node<E> parent) {
            this(value, null, null, parent);
        }

        public Node(E value, Node<E> left, Node<E> right, Node<E> parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
