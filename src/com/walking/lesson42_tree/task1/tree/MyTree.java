package com.walking.lesson42_tree.task1.tree;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

public class MyTree<E extends Comparable<E>> {

    private Node<E> root = null;
    private Comparator<? super E> comparator = null;

    public MyTree() {
    }

    public MyTree(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (root == null) {
            root = newNode;
        } else {
            add(root, newNode);
        }
    }

    private void add(Node<E> currentNode, Node<E> newNode) {

        E currentNodeElement = currentNode.getElement();

        if (compare(currentNodeElement, newNode.getElement()) > 0) {
            addLeft(currentNode, newNode);
        } else {
            addRight(currentNode, newNode);
        }
    }

    private void addLeft(Node<E> currentNode, Node<E> newNode) {
        if (currentNode.getLeft() == null) {
            currentNode.setLeft(newNode);
        } else {
            add(currentNode.getLeft(), newNode);
        }
    }

    private void addRight(Node<E> currentNode, Node<E> newNode) {
        if (currentNode.getRight() == null) {
            currentNode.setRight(newNode);
        } else {
            add(currentNode.getRight(), newNode);
        }
    }

    public boolean remove(E element) {
        return remove(element, root);
    }

    private boolean remove(E element, Node<E> root) {
        if (root == null) {
            return false;
        }

        if (compare(element, root.getElement()) > 0) {
            return removeRight(element, root);
        } else {
            return removeLeft(element, root);
        }
    }

    private boolean removeLeft(E element, Node<E> currentNode) {
        Node<E> left = currentNode.getLeft();
        if (left == null || compare(element, left.getElement()) != 0) {
            return remove(element, left);
        } else {
            return removeLeftNode(left, currentNode);
        }
    }

    private boolean removeRight(E element, Node<E> currentNode) {
        Node<E> right = currentNode.getRight();
        if (right == null || compare(element, right.getElement()) != 0) {
            return remove(element, right);
        } else {
            return removeRightNode(right, currentNode);
        }
    }

    private boolean removeRightNode(Node<E> node, Node<E> parent) {
        boolean left = node.getLeft() == null;
        boolean right = node.getRight() == null;
        if (left && right) {
            parent.setRight(null);
        } else if (left) {
            parent.setRight(node.getRight());
        } else if (right) {
            parent.setRight(node.getLeft());
        } else {
            Node<E> max = getMax(node.getLeft(), null);
            parent.setRight(max);
            if (!node.getLeft().equals(max)) {
                max.setLeft(node.getLeft());
            }
            max.setRight(node.getRight());
        }

        return true;
    }

    private boolean removeLeftNode(Node<E> node, Node<E> parent) {
        boolean left = node.getLeft() == null;
        boolean right = node.getRight() == null;
        if (left && right) {
            parent.setLeft(null);
        } else if (left) {
            parent.setLeft(node.getRight());
        } else if (right) {
            parent.setLeft(node.getLeft());
        } else {
            Node<E> max = getMax(node.getLeft(), null);
            parent.setLeft(max);
            if (!node.getLeft().equals(max)) {
                max.setLeft(node.getLeft());
            }
            max.setRight(node.getRight());
        }

        return true;
    }

    private Node<E> getMax(Node<E> root, Node<E> parent) {

        if (root.getRight() != null) {
            return getMax(root.getRight(), root);
        }

        if (parent != null) {
            parent.setRight(root.getLeft());
        }

        return root;
    }

    private int compare(E element1, E element2) {
        if (comparator == null) {
            return element1.compareTo(element2);
        } else {
            return comparator.compare(element1, element2);
        }
    }

    public void printNodes() {
        if (root == null) {
            System.out.println("No elements in tree");
        } else {
            StringBuilder result = new StringBuilder();
            printNodes(root, result);
            System.out.println(result);
        }
    }

    private void printNodes(Node<E> root, StringBuilder result) {
        result.append(root.getElement()).append(" ");
        if (root.getLeft() != null) {
            printNodes(root.getLeft(), result);
        }
        if (root.getRight() != null) {
            printNodes(root.getRight(), result);
        }
    }

    public void printNodesV2() {
        if (root == null) {
            System.out.println("No elements in tree");
        } else {
            Deque<Node<E>> deque = new ArrayDeque<>();
            deque.add(root);
            StringBuilder result = new StringBuilder();
            printNodesV2(result, deque);
            System.out.println(result);
        }
    }

    private void printNodesV2(StringBuilder result, Deque<Node<E>> deque) {
        Node<E> currentNode = deque.pop();
        result.append(currentNode.getElement()).append(" ");
        if (currentNode.getLeft() != null) {
            deque.add(currentNode.getLeft());
        }
        if (currentNode.getRight() != null) {
            deque.add(currentNode.getRight());
        }
        if (!deque.isEmpty()) {
            printNodesV2(result, deque);
        }
    }

    private static class Node<E> {
        private Node<E> left;
        private Node<E> right;
        private final E element;

        Node(E element) {
            this.element = element;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public E getElement() {
            return element;
        }
    }
}