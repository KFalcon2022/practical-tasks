package com.walking.lesson42_tree.task1.Structure;

import java.util.Comparator;

public class BinaryTree<E> {
    private E value;
    private BinaryTree<E> root;

    public BinaryTree<E> getRoot() {
        return root;
    }

    public E getValue() {
        return value;
    }

    private BinaryTree<E> left;
    private BinaryTree<E> right;

    private Comparator<E> comparator;

    public BinaryTree() {
    }

    public BinaryTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public BinaryTree(E value) {
        this.value = value;
    }

    public void add(E e) {
        if (isEmpty()) {
            root = new BinaryTree<>(e);
        } else {
            add(e, root);
        }
        System.out.println(e);
    }

    private BinaryTree<E> add(E value, BinaryTree<E> node) {
        if (node == null) {
            return new BinaryTree<E>(value);
        }

        if (compare(value, node.value) <= 0) {
            node.left = add(value, node.left);
        } else {
            node.right = add(value, node.right);
        }

        return node;
    }

    public void remove(E e) {
        remove(e, root);
    }

    private BinaryTree<E> remove(E value, BinaryTree<E> tree) {
        if (tree == null) {
            return null;
        }

        BinaryTree<E> result = tree;
        int compareResult = compare(value, tree.value);

        if (compareResult < 0) {
            tree.left = remove(value, tree.left);
        } else if (compareResult > 0) {
            tree.right = remove(value, tree.right);
        } else if (tree.left != null && tree.right != null) {
            tree.value = findMax(tree.left).value;
            tree.left = remove(tree.value, tree.left);
        } else {
            result = tree.left != null ? tree.left : tree.right;
        }

        return result;
    }

    public Boolean isEmpty() {
        return root == null;
    }

    private int compare(E o1, E o2) {
        return comparator == null ? ((Comparable<? super E>) o1).compareTo((o2))
                : comparator.compare(o1, o2);

    }

    private BinaryTree<E> findMax(BinaryTree<E> tree) {
        if (tree == null) {
            return null;
        } else if (tree.left == null) {
            return tree;
        }

        return findMax(tree.right);
    }
}
