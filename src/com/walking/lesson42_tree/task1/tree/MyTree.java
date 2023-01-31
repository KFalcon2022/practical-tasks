package com.walking.lesson42_tree.task1.tree;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

public class MyTree<E extends Comparable<? super E>> {

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
        return remove(element, root, null);
    }

    private boolean remove(E element, Node<E> root, Node<E> parent) {
        if (root == null) {
            return false;
        }

        if (compare(element, root.getElement()) > 0) {
            return remove(element, root.getRight(), root);
        } else if (compare(element, root.getElement()) < 0) {
            return remove(element, root.getLeft(), root);
        } else {
            removeNode(root, parent);

            return true;
        }
    }

    private void removeNode(Node<E> node, Node<E> parent) {
        boolean left = node.getLeft() == null;
        boolean right = node.getRight() == null;

        if (left && right) {
            if (parent == null) {
                root = null;
            } else {
                replace(parent, node, null);
            }
        } else if (left) {
            if (parent == null) {
                root = root.getRight();
            } else {
                replace(parent, node, node.getRight());
            }
        } else if (right) {
            if (parent == null) {
                root = root.getLeft();
            } else {
                replace(parent, node, node.getLeft());
            }
        } else {
            Node<E> max = removeMax(node.getLeft(), null);
            if (parent == null) {
                root = max;
            }
            max.setRight(node.getRight());
            max.setLeft(node.getLeft());
        }
    }

    private void replace(Node<E> node, Node<E> oldValue, Node<E> newValue) {
        if (oldValue == node.getLeft()) {
            node.setLeft(newValue);
        } else {
            node.setRight(newValue);
        }
    }

    private Node<E> removeMax(Node<E> root, Node<E> parent) {

        if (root.getRight() != null) {
            return removeMax(root.getRight(), root);
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
            printNodes(root);
        }
        System.out.println("\n");
    }

    private void printNodes(Node<E> root) {
        System.out.print(root.getElement() + " ");
        if (root.getLeft() != null) {
            printNodes(root.getLeft());
        }
        if (root.getRight() != null) {
            printNodes(root.getRight());
        }
    }

    public void printNodesV2() {
        if (root == null) {
            System.out.println("No elements in tree");
        } else {
            Deque<Node<E>> deque = new ArrayDeque<>();
            deque.add(root);
            printNodesV2(deque);
        }
        System.out.println("\n");
    }

    private void printNodesV2(Deque<Node<E>> deque) {
        Node<E> currentNode = deque.pop();
        System.out.print(currentNode.getElement() + " ");
        if (currentNode.getLeft() != null) {
            deque.add(currentNode.getLeft());
        }
        if (currentNode.getRight() != null) {
            deque.add(currentNode.getRight());
        }
        if (!deque.isEmpty()) {
            printNodesV2(deque);
        }
    }

    private static class Node<E> {
        private Node<E> left;
        private Node<E> right;
        private E element;

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

        public void setElement(E element) {
            this.element = element;
        }
    }
}