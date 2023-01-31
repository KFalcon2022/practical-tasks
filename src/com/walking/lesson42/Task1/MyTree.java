package com.walking.lesson42.Task1;

import java.util.*;

public class MyTree<T> {

    protected Node<T> root;
    protected Comparator<T> comparator;

    public MyTree(Comparator<T> comp) {
        root = null;
        comparator = comp;
    }

    public void add(T value) {
        root = recursiveAdd(root, value);
    }

    private Node<T> recursiveAdd(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        if (comparator.compare(node.value, value) >= 0) {
            node.left = recursiveAdd(node.left, value);
        } else {
            node.right = recursiveAdd(node.right, value);
        }

        return node;
    }

    public void remove(T value) {
        recursiveRemove(root, value);
    }

    private Node<T> recursiveRemove(Node<T> node, T value) {
        if (node != null) {
            int result = comparator.compare(node.value, value);

            if (result > 0) {
                node.left = recursiveRemove(node.left, value);

            } else if (result < 0) {
                node.right = recursiveRemove(node.right, value);

            } else {
                if (node.left != null && node.right != null) {
                    Node<T> temp = getRightmostNode(node.left);
                    node.value = temp.value;
                    node.left = recursiveRemove(node.left, temp.value);

                } else if (node.left != null) {
                    node = node.left;

                } else if (node.right != null) {
                    node = node.right;

                } else {
                    node = null;
                }
            }
        }
        return node;
    }

    private Node<T> getRightmostNode(Node<T> node) {
        while (node.right != null){
            node = node.right;
        }
        return node;
    }

    public void walkPrint() {
        recursiveWalkPrint(root);
        System.out.print("\n");
    }

    private void recursiveWalkPrint(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + ", ");
        recursiveWalkPrint(node.left);
        recursiveWalkPrint(node.right);
    }

    public void widePrint(){
        Queue<Node<T>> nodes = new ArrayDeque<>();
        nodes.offer(root);
        T tempValue = null;
        while (!nodes.isEmpty()){
            Node<T> node = nodes.poll();
            if (tempValue == null || comparator.compare(node.value, tempValue) < 0) {
                tempValue = node.value;
                System.out.print("\n");
            }

            System.out.print(node.value + ", ");
            if (node.left != null) {
                nodes.offer(node.left);
            }
            if (node.right != null) {
                nodes.offer(node.right);
            }
        }
        System.out.print("\n");
    }

    public boolean search(T value) {
        return recursiveSearch(root, value);
    }

    private boolean recursiveSearch(Node<T> node, T value) {
        if (node == null) {
            return false;
        }
        int result = comparator.compare(node.value, value);
        if (result == 0) {
            return true;
        }
        return recursiveSearch(node.left, value) || recursiveSearch(node.right, value);
    }

    public class Node<T> {
        public Node<T> left;
        public Node<T> right;
        public T value;

        public Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
