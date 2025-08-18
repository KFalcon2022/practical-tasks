package com.walking.lesson42_tree.task1_easy.structure;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class UnbalancedBinaryTree<E> {
    private Node<E> root;

    private int level;


    public void add(E e) {
        if (root == null) {
            root = new Node<>(e);
            System.out.printf("Element %s added\n", e.toString());
            return;
        }

        add(root, new Node<>(e));
    }

    private void add(Node<E> current, Node<E> node) {
        if (node.compareTo(current) > 0) {
            if (current.right == null) {
                current.right = node;
                System.out.printf("element %s added\n", node.value.toString());
                return;
            }

            add(current.right, node);
            return;
        }

        if (current.left == null) {
            current.left = node;
            System.out.printf("element %s added\n", node.value.toString());
            return;
        }

        add(current.left, node);
    }

    public E getMaxLeaf() {
        if (root == null) {
            System.out.println("Main root is null! ");
            return null;
        }

        return getMaxLeaf(root);
    }

    public E getMaxLeaf(Node<E> current) {
        if (current == null) {
            System.out.println("Current root is null!");
            return null;
        }

        if (current.right == null) {
            return current.value;
        }

        return getMaxLeaf(current.right);
    }

    public E getMinLeaf() {
        if (root == null) {
            System.out.println("Main root is null!");
            return null;
        }

        return getMinLeaf(root);
    }

    public E getMinLeaf(Node<E> currentRoot) {
        if (currentRoot == null) {
            System.out.println("Current Root is null! ");
            return null;
        }

        if (currentRoot.left == null) {
            return currentRoot.value;
        }

        return getMinLeaf(currentRoot.left);
    }

    private boolean isHasTwoChild(Node<E> currentRoot) {
        return currentRoot.left != null && currentRoot.right != null;
    }

    private boolean isHasRightChild(Node<E> currentRot) {
        return currentRot.right != null;
    }

    private boolean isHasLeftChild(Node<E> currentRoot) {
        return currentRoot.left != null;
    }

    private Node<E> findParentNode(Node<E> required) {
        if (root == null) {
            System.out.println("Required node not found");
            return null;
        }

        if (required.compareTo(root) == 0) {
            throw new RuntimeException("Required node doesn't have a parent!");
        }

        return required.compareTo(root) > 0
                ? findParentNode(root.right, required)
                : findParentNode(root.left, required);
    }

    private Node<E> findParentNode(Node<E> current, Node<E> required) {
        if (current == null) {
            throw new RuntimeException("Element not found");
        }

        if (isHasLeftChild(current) || isHasRightChild(current)) {
            if (required.compareTo(current.left) == 0 || required.compareTo(current.right) == 0) {
                return current;
            }
        }

        return required.compareTo(current) > 0
                ? findParentNode(current.right, required)
                : findParentNode(current.left, required);
    }

    public Node<E> delete(E e) { //Удаление по значению
        Node<E> required = new Node<>(e);
        Node<E> parentNode = findParentNode(required); //находим родительский узел, один из потомков которого является удаляемым узлом
        if (parentNode == null) {
            throw new RuntimeException("Element not found");
        }

        return delete(required, parentNode);
    }

    private Node<E> delete(Node<E> required) { // удаление по Узлу
        Node<E> parent = findParentNode(required);
        if (parent == null) {
            throw new RuntimeException("Element not found");
        }

        return delete(required, parent);
    }

    private @NotNull Node<E> delete(Node<E> required, Node<E> parent) {
        Node<E> removed;
        if (required.compareTo(parent.left) == 0) { //Если необходимо удалить левого потомка родительского узла
            removed = parent.left; //Присваеваем ссылку на удаляемый узел(здесь - левый) во временную переменную, которую будем возвращать

            if (isHasTwoChild(parent.left)) {// если удаляемый узел имеет двух потомков
                parent.left = delete(getMaxLeaf(parent.left.left));// ищем максимальный лист левого потомка удаляемого элемента
//                    // и присваеваем ссылку, удаляя ссылку на найденный лист
            } else if (isHasLeftChild(parent.left)) {// если удаляемый элемент имеет только левого потомка
                parent.left = parent.left.left;
            } else {
                parent.left = parent.left.right;
            }
        } else {  // в противном случае мы точно понимаем, что нам нужно удалить правого потомка родительского узла
            removed = parent.right; //Присваеваем ссылку на удаляемый узел(здесь - правый) во временную переменную, которую будем возвращать

            if (isHasTwoChild(parent.right)) {
                parent.right = delete(parent.right.left);
            } else if (isHasLeftChild(parent.right)) {
                parent.right = parent.right.left;
            } else {
                parent.right = parent.right.right;
            }
        }

        System.out.printf("Element %s deleted\n", removed.value);
        return removed;
    }

    public void straightBypass() {
        if (root == null) {
            System.out.println("Root is empty");
            return;
        }
        List<E> list = new LinkedList<>();
        list.add(root.value);

        if (isHasLeftChild(root)) {
            straightBypass(root.left, list);
        }

        if (isHasRightChild(root)) {
            straightBypass(root.right, list);
        }

        for (Object o : list) {
            System.out.println(o);
        }
    }

    private void straightBypass(Node<E> current, Collection<E> list) {
        if (current == null) {
            return;
        }

        list.add(current.value);

        if (isHasLeftChild(current)) {
            straightBypass(current.left, list);
        }

        if (isHasRightChild(current)) {
            straightBypass(current.right, list);
        }
    }

    public void middleBypass() {
        if (root == null) {
            System.out.println("Root is empty!");
            return;
        }

        List<E> list = new LinkedList<>();

        if (isHasLeftChild(root)) {
            middleBypass(root.left, list);
        }

        list.add(root.value);

        if (isHasRightChild(root)) {
            middleBypass(root.right, list);
        }

        for (Object o : list) {
            System.out.println(o);
        }
    }

    private void middleBypass(Node<E> current, Collection<E> list) {
        if (current == null) {
            return;
        }

        if (isHasLeftChild(current)) {
            middleBypass(current.left, list);
        }

        list.add(current.value);

        if (isHasRightChild(current)) {
            middleBypass(current.right, list);
        }
    }

    public void reverseBypass() {
        if (root == null) {
            System.out.println("Root is empty");
            return;
        }
        List<E> list = new LinkedList<>();

        if (isHasLeftChild(root)) {
            reverseBypass(root.left, list);
        }

        if (isHasRightChild(root)) {
            reverseBypass(root.right, list);
        }

        list.add(root.value);

        for (Object o : list) {
            System.out.println(o);
        }
    }

    private void reverseBypass(Node<E> current, Collection<E> list) {
        if (current == null) {
            return;
        }

        if (isHasLeftChild(current)) {
            reverseBypass(current.left, list);
        }

        if (isHasRightChild(current)) {
            reverseBypass(current.right, list);
        }

        list.add(current.value);
    }

    public void widthBypass() {
        if (root == null) {
            System.out.println("Root is empty!");
            return;
        }

        List<E> valueQueue = new LinkedList<>();
        Queue<Node<E>> nodeQueue = new LinkedList<>();
        valueQueue.add(root.value);

        if (isHasLeftChild(root)) {
            valueQueue.add(root.left.value);
            nodeQueue.add(root.left);
        }
        if (isHasRightChild(root)) {
            valueQueue.add(root.right.value);
            nodeQueue.add(root.right);
        }

        widthBypass(valueQueue, nodeQueue);

        for (E e : valueQueue) {
            System.out.println(e);
        }
    }

    private void widthBypass(Collection<E> collection, Queue<Node<E>> nodeQueue) {
        if (nodeQueue.isEmpty()) {
            return;
        }

        Queue<Node<E>> newNodeQueue = new LinkedList<>();
        for (Node<E> n : nodeQueue) {
            if (isHasLeftChild(n)) {
                collection.add(n.left.value);
                newNodeQueue.add(n.left);
            }

            if (isHasRightChild(n)) {
                collection.add(n.right.value);
                newNodeQueue.add(n.right);
            }
        }

        widthBypass(collection, newNodeQueue);
    }

    public class Node<E> implements Comparable<Node<E>> {
        private final E value;

        private Node<E> left;
        private Node<E> right;
        private int level;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public int getLevel() {
            return level;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node<E> node = (Node<E>) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }

        @Override
        public int compareTo(@NotNull Node<E> o) {
            if (hashCode() < o.hashCode()) {
                return -1;
            }

            if (hashCode() > o.hashCode()) {
                return 1;
            }

            return 0;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
