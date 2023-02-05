package com.walking.lesson42_tree.task1.structure;

import java.util.*;

public class BinarySearchTree<T> {
    private Node<T> root;

    private Comparator<T> comparator;

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public BinarySearchTree() {

    }

    public void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T value) {
        return contains(value, root);
    }

    public void add(T value) {
        if (isEmpty()) {
            compare(value, value);
        }

        root = add(value, root);
    }

    public void remove(T value) {
        remove(value, root);
    }

    public void balance() {
        if (root == null) {
            return;
        }

        List<T> values = bypassDepth(root, new ArrayList<>());
        values.sort(comparator == null ? (Comparator<? super T>) Comparator.naturalOrder() : comparator);

        root = balance(0, values.size(), values);
    }

    private Node<T> balance(int firstIndex, int lastIndex, List<T> values) {
        if (firstIndex == lastIndex) {
            return null;
        }

        int middleIndex = (firstIndex + lastIndex) / 2;
        Node<T> newNode = new Node<>(values.get(middleIndex));
        newNode.left = balance(firstIndex, middleIndex, values);
        newNode.right = balance(middleIndex + 1, lastIndex, values);

        return newNode;
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

    private Node<T> add(T value, Node<T> node) {
        if (node == null) {
            return new Node<>(value);
        }

        if (compare(value, node.value) <= 0) {
            node.left = add(value, node.left);
        } else {
            node.right = add(value, node.right);
        }

        return node;
    }

    private Node<T> remove(T value, Node<T> node) {
        if (node == null) {
            return null;
        }

        Node<T> result = node;
        int compareResult = compare(value, node.value);

        if (compareResult < 0) {
            node.left = remove(value, node.left);
        } else if (compareResult > 0) {
            node.right = remove(value, node.right);
        } else if (node.left != null && node.right != null) {
            node.value = findMax(node.left).value;
            node.left = remove(node.value, node.left);
        } else {
            result = node.left != null ? node.left : node.right;
        }

        return result;
    }

    private Node<T> findMax(Node<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        }
        return findMax(node.right);
    }

    private boolean contains(T value, Node<T> node) {
        if (node == null) {
            return false;
        }

        int compareResult = compare(value, node.value);
        if (compareResult == 0) {
            return true;
        }

        return compareResult > 0 ? contains(value, node.right) : contains(value, node.left);
    }

//        Если класс параметризован типом, не реализующим Comparable и объект класса был создан без Comparator'а -
//        каждая операция сравнения будет завершаться с NPE
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

    }
}
