package com.walking.lesson42_tree.task1.tree;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

public class MyTreeV2<E extends Comparable<? super E>> {

    private Node<E> root;
    private Comparator<? super E> comparator = null;

    public MyTreeV2() {
    }

    public MyTreeV2(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    public void add(E element) {
        if (root == null) {
            root = new Node<>(element);
        } else {
            add(root, element);
        }
    }

    private void add(Node<E> tree, E element) {

        if (compare(tree.getElement(), element) > 0) {
            if (tree.getLeft() == null) {
                tree.setLeft(new Node<>(element));
                return;
            }
            add(tree.getLeft(), element);
        } else {
            if (tree.getRight() == null) {
                tree.setRight(new Node<>(element));
                return;
            }
            add(tree.getRight(), element);
        }
    }

    public void remove(E element) {
        Node<E> remove = remove(element, root);
        if (compare(root.element, element) == 0) {
            if (remove != null) {
                root = remove;
            } else {
                root = root.right;
            }
        }
    }

    private Node<E> remove(E element, Node<E> tree) {
        if (tree == null) {
            return null;
        }

        if (compare(element, tree.getElement()) > 0) {
            tree.right = remove(element, tree.getRight());

            return tree;
        } else if (compare(element, tree.getElement()) < 0) {
            tree.left = remove(element, tree.getLeft());

            return tree;
        } else {
            return removeNode(tree);
        }
    }

    private Node<E> removeNode(Node<E> node) {
        boolean leftNull = node.getLeft() == null;
        boolean rightNull = node.getRight() == null;

        if (leftNull && rightNull) {
            return null;
        } else if (leftNull) {
            return node.getRight();
        } else if (rightNull) {
            return node.getLeft();
        } else {
            Node<E> maxLeft = removeMax(node.getLeft(), null);

            maxLeft.setRight(node.getRight());
            if (node.getLeft() != maxLeft) {
                maxLeft.setLeft(node.getLeft());
            }

            return maxLeft;
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

    private void printNodes(Node<E> tree) {
        System.out.print(tree.getElement() + " ");
        if (tree.getLeft() != null) {
            printNodes(tree.getLeft());
        }
        if (tree.getRight() != null) {
            printNodes(tree.getRight());
        }
    }

    public void printNodesV2() {
        if (root == null) {
            System.out.println("No elements in tree");
        } else {
            Deque<Node<E>> deque = new ArrayDeque<>();
            deque.offer(root);
            printNodesV2(deque);
        }
        System.out.println("\n");
    }

    private void printNodesV2(Deque<Node<E>> deque) {
        Node<E> currentNode = deque.pop();
        System.out.print(currentNode.getElement() + " ");

        if (currentNode.getLeft() != null) {
            deque.offer(currentNode.getLeft());
        }
        if (currentNode.getRight() != null) {
            deque.offer(currentNode.getRight());
        }
        if (!deque.isEmpty()) {
            printNodesV2(deque);
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
