package com.walking.lesson42_tree.task1.structure;

import java.util.*;

/**
 * При удалении узлы помечаются как удаленные, но остаются в дереве.
 * <p>
 * Итеративные алгоритмы поиска, добавления и удаления.
 */
public class BinarySearchTree_v2<E> {
    private Node<E> root;
    private final Comparator<? super E> comparator;

    public BinarySearchTree_v2() {
        comparator = null;
    }

    public BinarySearchTree_v2(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    public E getRoot() {
        return root != null ? root.value : null;
    }

    public E get(E key) {
        Node<E> found = get(key, root);

        return found != null ? found.value : null;
    }

    public E getMin() {
        Node<E> found = getMinNode(root);

        return found != null ? found.value : null;
    }

    public E getMax() {
        Node<E> found = getMaxNode(root);

        return found != null ? found.value : null;
    }

    public E put(E key) {
        if (root == null) {
            root = new Node<>(key);

            return root.value;
        }

        int route = getRouteByKey(key, root.value);

        if (isSearchHit(route) && root.isDeleted) {
            root = new Node<>(key, root.left, root.right);

            return root.value;
        }

        Node<E> parent = root;
        Node<E> current = isLeftBranch(route) ? root.left : root.right;
        Node<E> newborn = new Node<>(key);

        while (current != null) {
            route = getRouteByKey(key, current.value);

            if (isSearchHit(route) && current.isDeleted) {
                newborn.left = current.left;
                newborn.right = current.right;
                current = null;
            } else {
                parent = current;
                current = isLeftBranch(route) ? current.left : current.right;
            }
        }

        if (isLeftBranch(route)) {
            parent.left = newborn;
        } else {
            parent.right = newborn;
        }

        return newborn.value;
    }

    public E remove(E key) {
        Node<E> removed = get(key, root);

        if (removed != null) {
            removed.isDeleted = true;
        }

        return removed != null ? removed.value : null;
    }

    public List<E> getAscendingOrder() {
        List<E> inOrder = new ArrayList<>();

        inOrderToList(root, inOrder);

        return inOrder;
    }

    public void breadthFirstSearchTraversal() {
        if (root == null) {
            return;
        }

        Queue<Node<E>> unvisitedNodes = new ArrayDeque<>();
        Node<E> current;

        unvisitedNodes.offer(root);

        while (!unvisitedNodes.isEmpty()) {
            current = unvisitedNodes.poll();

            visitNode(current);

            if (current.hasLeftChild()) {
                unvisitedNodes.offer(current.left);
            }

            if (current.hasRightChild()) {
                unvisitedNodes.offer(current.right);
            }
        }
    }

    public void balance() {
        if (root == null) {
            return;
        }

        List<E> inorder = getInOrderList();
        List<E> middles = new ArrayList<>(inorder.size());

        middleExtraction(inorder, middles);

        BinarySearchTree_v2<E> balanced = new BinarySearchTree_v2<>(this.comparator);

        for (E middle : middles) {
            balanced.put(middle);
        }

        this.root = balanced.root;
    }

    private void visitNode(Node<E> current) {
        if (!current.isDeleted) {
            System.out.print(current.value);
        }
    }

    private Node<E> get(E key, Node<E> localRoot) {
        int route;

        while (localRoot != null) {
            route = getRouteByKey(key, localRoot.value);

            if (isSearchHit(route) && !localRoot.isDeleted) {
                return localRoot;
            }

            localRoot = isLeftBranch(route) ? localRoot.left : localRoot.right;
        }

        return null;
    }

    private Node<E> getMinNode(Node<E> localRoot) {
        if (localRoot == null) {
            return null;
        }

        Node<E> found = getMinNode(localRoot.left);

        return found != null ? found : !localRoot.isDeleted ? localRoot : getMinNode(localRoot.right);
    }

    private Node<E> getMaxNode(Node<E> localRoot) {
        if (localRoot == null) {
            return null;
        }

        Node<E> found = getMaxNode(localRoot.right);

        return found != null ? found : !localRoot.isDeleted ? localRoot : getMinNode(localRoot.left);
    }

    private void middleExtraction(List<E> source, List<E> middles) {
        if (source.size() == 0) {
            return;
        }

        int middleIndex = source.size() / 2;
        middles.add(source.get(middleIndex));

        middleExtraction(source.subList(0, middleIndex), middles);
        middleExtraction(source.subList(++middleIndex, source.size()), middles);
    }

    private List<E> getInOrderList() {
        List<E> inOrder = new ArrayList<>();

        inOrderToList(root, inOrder);

        return inOrder;
    }

    private void inOrderToList(Node<E> localRoot, List<E> list) {
        if (localRoot == null) {
            return;
        }

        inOrderToList(localRoot.left, list);

        if (!localRoot.isDeleted) {
            list.add(localRoot.value);
        }

        inOrderToList(localRoot.right, list);
    }

    private int getRouteByKey(E keyValue, E currentValue) {
        if (comparator != null) {
            return comparator.compare(keyValue, currentValue);
        } else {
            Comparable<E> comparable = (Comparable<E>) keyValue;
            return comparable.compareTo(currentValue);
        }
    }

    private boolean isSearchHit(int comparisonResult) {
        return comparisonResult == 0;
    }

    private boolean isLeftBranch(int comparisonResult) {
        return comparisonResult <= 0;
    }

    private static class Node<E> {
        private final E value;
        private Node<E> left;
        private Node<E> right;
        private boolean isDeleted;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> left, Node<E> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        private boolean hasLeftChild() {
            return left != null;
        }

        private boolean hasRightChild() {
            return right != null;
        }
    }
}
