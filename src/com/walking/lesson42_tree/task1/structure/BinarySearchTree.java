package com.walking.lesson42_tree.task1.structure;

import java.util.*;

public class BinarySearchTree<E> {
    private Node<E> root;
    private final Comparator<? super E> comparator;

    public BinarySearchTree() {
        comparator = null;
    }

    public BinarySearchTree(Comparator<? super E> comparator) {
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
        Node<E> minNode = getMinNode(root);

        return minNode != null ? minNode.value : null;
    }

    public E getMax() {
        Node<E> maxNode = getMaxNode(root);

        return maxNode != null ? maxNode.value : null;
    }

    public void put(E key) {
        root = put(key, root);
    }

    public E remove(E key) {
        Node<E> removed = removeNode(key, root, null);

        return removed != null ? removed.value : null;
    }

    public List<E> getAscendingOrder() {
        List<E> list = new ArrayList<>();

        inOrderToList(root, list);

        return list;
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

        BinarySearchTree<E> balanced = new BinarySearchTree<E>(this.comparator);

        for (E middle : middles) {
            balanced.put(middle);
        }

        this.root = balanced.root;
    }

    private void visitNode(Node<E> current) {
        System.out.print(current.value);
    }

    private Node<E> get(E key, Node<E> localRoot) {
        if (localRoot == null) {
            return null;
        }

        int route = getRouteByKey(key, localRoot.value);

        return isSearchHit(route) ?
                localRoot :
                isLeftBranch(route) ? get(key, localRoot.left) : get(key, localRoot.right);
    }

    private Node<E> getMinNode(Node<E> localRoot) {
        return (localRoot != null && localRoot.hasLeftChild()) ? getMinNode(localRoot.left) : localRoot;
    }

    private Node<E> getMaxNode(Node<E> localRoot) {
        return (localRoot != null && localRoot.hasRightChild()) ? getMaxNode(localRoot.right) : localRoot;
    }

    private Node<E> put(E key, Node<E> localRoot) {
        if (localRoot == null) {
            return new Node<>(key);
        }

        int route = getRouteByKey(key, localRoot.value);

        if (isLeftBranch(route)) {
            localRoot.left = put(key, localRoot.left);
        } else {
            localRoot.right = put(key, localRoot.right);
        }

        return localRoot;
    }

    private Node<E> removeNode(E key, Node<E> localRoot, Node<E> parent) {
        if (localRoot == null) {
            return null;
        }

        int route = getRouteByKey(key, localRoot.value);

        return isSearchHit(route) ?
                removeFound(localRoot, parent) :
                isLeftBranch(route) ?
                        removeNode(key, localRoot.left, localRoot) :
                        removeNode(key, localRoot.right, localRoot);
    }

    private Node<E> removeFound(Node<E> found, Node<E> parent) {
        Node<E> newborn = found.hasTwoChild() ? removeSuccessor(found, parent) : getFoundChild(found);

        linkParentWithNewborn(found, parent, newborn);

        return found;
    }

    private Node<E> removeSuccessor(Node<E> found, Node<E> parent) {
        Node<E> successor = getMaxNode(found.left);

        removeNode(successor.value, found, parent);

        successor.left = found.left;
        successor.right = found.right;

        return successor;
    }

    private Node<E> getFoundChild(Node<E> found) {
        return found.hasLeftChild() ? found.left : found.right;
    }

    private void linkParentWithNewborn(Node<E> found, Node<E> parent, Node<E> newborn) {
        if (found == root) {
            root = newborn;
        } else if (found == parent.left) {
            parent.left = newborn;
        } else {
            parent.right = newborn;
        }
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
        List<E> list = new ArrayList<>();

        inOrderToList(root, list);

        return list;
    }

    private void inOrderToList(Node<E> localRoot, List<E> list) {
        if (localRoot == null) {
            return;
        }

        inOrderToList(localRoot.left, list);

        list.add(localRoot.value);

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

    private boolean isLeftBranch(int result) {
        return result <= 0;
    }

    private boolean isSearchHit(int route) {
        return route == 0;
    }

    private static class Node<E> {
        private final E value;
        private Node<E> left;
        private Node<E> right;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> left, Node<E> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        private boolean hasTwoChild() {
            return right != null && left != null;
        }

        private boolean hasLeftChild() {
            return left != null;
        }

        private boolean hasRightChild() {
            return right != null;
        }
    }
}