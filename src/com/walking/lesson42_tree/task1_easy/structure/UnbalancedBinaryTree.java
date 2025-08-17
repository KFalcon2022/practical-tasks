package com.walking.lesson42_tree.task1_easy.structure;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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

    private void add(Node<E> currentRoot, Node<E> node) {
        if (node.compareTo(currentRoot) > 0) {
            if (currentRoot.right == null) {
                currentRoot.right = node;
                System.out.printf("element %s added\n", node.value.toString());
                return;
            }

            add(currentRoot.right, node);
            return;
        }

        if (currentRoot.left == null) {
            currentRoot.left = node;
            System.out.printf("element %s added\n", node.value.toString());
            return;
        }

        add(currentRoot.left, node);
    }

    public Node<E> getMaxLeaf() {
        if (root == null) {
            System.out.println("Main root is null! ");
            return null;
        }

        return getMaxLeaf(root);
    }

    public Node<E> getMaxLeaf(Node<E> currentRoot) {
        if (currentRoot == null) {
            System.out.println("Current root is null!");
            return null;
        }

        if (currentRoot.right == null) {
            return currentRoot;
        }

        return getMaxLeaf(currentRoot.right);
    }

    public Node<E> getMinLeaf() {
        if (root == null) {
            System.out.println("Main root is null!");
            return null;
        }

        return getMinLeaf(root);
    }

    public Node<E> getMinLeaf(Node<E> currentRoot) {
        if (currentRoot == null) {
            System.out.println("Current Root is null! ");
            return null;
        }

        if (currentRoot.left == null) {
            return currentRoot;
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

    public Node<E> findNode(E e) {
        if (root == null) {
            System.out.println("Element not found");
            return null;
        }

        Node<E> required = new Node<>(e);

        if (required.compareTo(root) == 0) {
            System.out.println("Required node is root!");
            return root;
        }

        return required.compareTo(root) > 0
                ? findNode(root.right, required)
                : findNode(root.left, required);
    }

    private Node<E> findNode(Node<E> currentNode, Node<E> required) {
        if (currentNode == null) {
            System.out.println("Element not found");
            return null;
        }

        if (required.compareTo(currentNode) == 0) {
            System.out.println("Required node found!");
            return currentNode;
        }

        return required.compareTo(currentNode) > 0
                ? findNode(currentNode.right, required)
                : findNode(currentNode.left, required);
    }

    private Node<E> findNodesParent(Node<E> required) {
        if (root == null) {
            System.out.println("Required node not found");
            return null;
        }

        if (required.compareTo(root) == 0) {
            System.out.println("Required node doesn't have a parent!");
            return null;
        }

        return required.compareTo(root) > 0
                ? findNodesParent(root.right, required)
                : findNodesParent(root.left, required);
    }

    private Node<E> findNodesParent(Node<E> current, Node<E> required) {
        if (current == null) {
            System.out.println("Element not found");
            return null;
        }

        if (required.compareTo(current.left) == 0 || required.compareTo(current.right) == 0) {
            return current;
        }

        return required.compareTo(current) > 0
                ? findNodesParent(current.right, required)
                : findNodesParent(current.left, required);
    }

    public Node<E> delete(E e) {
        Node<E> required = new Node<>(e);
        Node<E> found = findNodesParent(required); //находим родительский узел, один из потомков которого является удаляемым узлом
        if (found == null) {
            return null;
        }

        return delete(required, found);
    }

    private Node<E> delete(Node<E> required) {
        Node<E> parent = findNodesParent(required);
        if (parent == null) {
            return null;
        }

        return delete(required, parent);
    }

    private @NotNull Node<E> delete(Node<E> node, Node<E> found) {
        Node<E> removed;
        if (node.compareTo(found.left) == 0) { //Если необходимо удалить левого потомка родительского узла
            removed = found.left; //Присваеваем ссылку на удаляемый узел(здесь - левый) во временную переменную, которую будем возвращать

            if (isHasTwoChild(found.left)) {// если удаляемый узел имеет двух потомков
                found.left = delete(getMaxLeaf(found.left.left));// ищем максимальный лист левого потомка удаляемого элемента
//                    // и присваеваем ссылку, удаляя ссылку на найденный лист
            } else if (isHasLeftChild(found.left)) {// если удаляемый элемент имеет только левого потомка
                found.left = found.left.left;
            } else {
                found.left = found.left.right;
            }

            return removed;
//            found.left = isHasTwoChild(found.left) // если удаляемый узел имеет двух потомков
//                    ? delete(getMaxLeaf(found.left.left)) // ищем максимальный лист левого потомка удаляемого элемента
//                    // и присваеваем ссылку, удаляя ссылку на найденный лист
//                    : isHasLeftChild(found.left) // если левый потомок удаляемого элемента имеет только левого потомка
//                    ? found.left.left
//                    : isHasRightChild(found.left)
//                    ? found.left.right
//                    : null;
        } else {  // в противном случае мы точно понимаем, что нам нужно удалить правого потомка родительского узла
            removed = found.right; //Присваеваем ссылку на удаляемый узел(здесь - правый) во временную переменную, которую будем возвращать

            if (isHasTwoChild(found.right)) {
                found.right = delete(found.right.left);
            } else if (isHasLeftChild(found.right)) {
                found.right = found.right.left;
            } else {
                found.right = found.right.right;
            }

            return removed;
//            found.right = isHasTwoChild(found.right) // если удаляемый элемент имеет двух потомков
//                    ? delete(getMaxLeaf(found.right.left)) //Ищем максимальный лист левого потомка удаляемого узла
//                    // и присваеваем ссылку, удаляя ссылку на найденный лист
//                    : isHasLeftChild(found.right) // Если удаляемый узел имеет только левого потомка
//                    ? found.right.left
//                    : isHasRightChild(found.right)
//                    ? found.right.right
//                    : null;
        }
    }

    public void straightPrintTree() {
        if (root == null) {
            System.out.println("Root is empty");
            return;
        }
        List<E> list = new LinkedList<>();
        list.add(root.value);

        if (isHasLeftChild(root)) {
            straightPrintTree(root.left, list);
        }

        if (isHasRightChild(root)) {
            straightPrintTree(root.right, list);
        }

        for (Object o : list) {
            System.out.println(o);
        }
    }

    private void straightPrintTree(Node<E> current, Collection<E> list) {
        if (current == null) {
            return;
        }

        list.add(current.value);

        if (isHasLeftChild(current)) {
            straightPrintTree(current.left, list);
        }

        if (isHasRightChild(current)) {
            straightPrintTree(current.right, list);
        }
    }

    public void middlePrintTree() {
        if (root == null) {
            System.out.println("Root is empty!");
            return;
        }

        List<E> list = new LinkedList<>();

        if (isHasLeftChild(root)) {
            middlePrintTree(root.left, list);
        }

        list.add(root.value);

        if (isHasRightChild(root)) {
            middlePrintTree(root.right, list);
        }

        for (Object o : list) {
            System.out.println(o);
        }
    }

    private void middlePrintTree(Node<E> current, Collection<E> list) {
        if (current == null) {
            return;
        }

        if (isHasLeftChild(current)) {
            middlePrintTree(current.left, list);
        }

        list.add(current.value);

        if (isHasRightChild(current)) {
            middlePrintTree(current.right, list);
        }
    }

    public void reversePrintTree() {
        if (root == null) {
            System.out.println("Root is empty");
            return;
        }
        List<E> list = new LinkedList<>();

        if (isHasLeftChild(root)) {
            reversePrintTree(root.left, list);
        }

        if (isHasRightChild(root)) {
            reversePrintTree(root.right, list);
        }

        list.add(root.value);

        for (Object o : list) {
            System.out.println(o);
        }
    }

    private void reversePrintTree(Node<E> current, Collection<E> list) {
        if (current == null) {
            return;
        }

        if (isHasLeftChild(current)) {
            reversePrintTree(current.left, list);
        }

        if (isHasRightChild(current)) {
            reversePrintTree(current.right, list);
        }

        list.add(current.value);
    }

    public void widthPrintTree() {

    }

    public class Node<E> implements Comparable<Node<E>> {
        private final E value;

        private Node<E> left;
        private Node<E> right;
        private int level;

        public Node(E value) {
            this.value = value;
        }

        public Node(Node<E> left, E value, Node<E> right) {
            this.left = left;
            this.value = value;
            this.right = right;
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
