package com.walking.lesson42_tree.task1_hard.structure;

import java.util.*;

public class BinarySearchTree<E> {
    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

//    public void clear() {
//        root = null;
//    }
//
//    public boolean isEmpty() {
//        return root == null;
//    }
    //Эти два метода у тебя увидел, по этому их в комментарии занёс.

//    public void balance() {
//        if (root == null) {
//            System.out.println("Root is empty");
//            return;
//        }
//
//        List<E> values = new ArrayList<>(List.copyOf(bypassMiddle()));
//
//        root = doBalance(0, values.size(), values);
//    }
//
//    private Node<E> doBalance(int firstIndex, int lastIndex, List<E> values) {
//        if (firstIndex == lastIndex) {
//            return null;
//        }
//
//        int middleIndex = (firstIndex + lastIndex) / 2;
//        Node<E> node = new Node<>(values.get(middleIndex));
//        node.left = doBalance(firstIndex, middleIndex, values);
//        node.right = doBalance(middleIndex + 1, lastIndex, values);
//
//        return node;
//    }
    // Очень долго думал, в итоге вроде сначала по чуть подглядывал в твоё решение, а по итогу всё переписал подчистую)

    public void add(E e) {
        if (root == null) {
            root = new Node<>(e);
            return;
        }

        add(root, new Node<>(e));
    }

    private void add(Node<E> current, Node<E> added) {
        if (compare(added.value, current.value) > 0) {
            if (current.right == null) {
                current.right = added;
                return;
            }

            add(current.right, added);
            return;
        }

        if (current.left == null) {
            current.left = added;
            return;
        }

        add(current.left, added);
    }

    public E getMaxLeaf() {
        if (root == null) {
            throw new RuntimeException("Root is empty");
        }

        return getMaxLeaf(root);
    }

    private E getMaxLeaf(Node<E> current) {
        if (current.right == null) {
            return current.value;
        }

        return getMaxLeaf(current.right);
    }

    private E getMinLeaf() {
        if (root == null) {
            throw new RuntimeException("Root is empty");
        }

        return getMinLeaf(root);
    }

    private E getMinLeaf(Node<E> current) {
        if (current.left == null) {
            return current.value;
        }

        return getMinLeaf(current.left);
    }

    private boolean isHasTwoChild(Node<E> current) {
        return current.left != null && current.right != null;
    }

    private boolean isHasLeftChild(Node<E> current) {
        return current.left != null;
    }

    private boolean isHasRightChild(Node<E> current) {
        return current.right != null;
    }

    private Node<E> findParentNode(E value) {
        if (root == null) {
            throw new RuntimeException("root is empty");
        }

        return findParentNode(root, value);
    }

    private Node<E> findParentNode(Node<E> current, E value) {
        if (current == null) {
            throw new RuntimeException("Element not found");
        }

        if (isHasLeftChild(current)) {
            if (compare(current.left.value, value) == 0) {
                return current;
            }
        }

        if (isHasRightChild(current)) {
            if (compare(current.right.value, value) == 0) {
                return current;
            }
        }

        return compare(value, current.value) > 0
                ? findParentNode(current.right, value)
                : findParentNode(current.left, value);
    }

    public E delete(E value) {
        if (root == null) {
            throw new RuntimeException("Root is empty!");
        }

        if (root.value == value) {
            E removed = root.value;
            root.value = delete(root.left, value);
            System.out.printf("Element '%s' deleted!\n", value);

            return removed;
        }

        Node<E> parent = findParentNode(value);

        return delete(parent, value);
    }

    private E delete(Node<E> parent, E value) {
        E removed;
        if (parent.left != null && compare(value, parent.left.value) == 0) {// Если необходимо удалить левого потомка родительского узла
            removed = parent.left.value;// Присваиваем значение удаляемого узла, которое будем возвращать

            if (isHasTwoChild(parent.left)) {//Если удаляемый узел имеет двух потомков
                parent.left.value = delete(getMaxLeaf(parent.left));//Ищем максимальный лист левого потомка удаляемого Элемента
                // и присваиваем значение, удаляя значение найденного листа
            } else if (isHasLeftChild(parent.left)) {
                parent.left = parent.left.left;
            } else {
                parent.left = parent.left.right;
            }
        } else {
            removed = parent.right.value;

            if (isHasTwoChild(parent.right)) {
                parent.right.value = delete(getMaxLeaf(parent.right.left));
            } else if (isHasLeftChild(parent.right)) {
                parent.right = parent.right.left;
            } else {
                parent.right = parent.right.right;
            }
        }

        System.out.printf("Element '%s' deleted!\n", removed.toString());
        return removed;
    }

    public List<E> bypassStraight() {
        if (root == null) {
            throw new RuntimeException("Root is empty!");
        }

        List<E> list = new LinkedList<>();
        list.add(root.value);
        if (isHasLeftChild(root)) {
            bypassStraight(root.left, list);
        }

        if (isHasRightChild(root)) {
            bypassStraight(root.right, list);
        }

        return list;
    }

    private void bypassStraight(Node<E> current, List<E> list) {
        if (current == null) {
            return;
        }

        list.add(current.value);

        if (isHasLeftChild(current)) {
            bypassStraight(current.left, list);
        }

        if (isHasRightChild(current)) {
            bypassStraight(current.right, list);
        }
    }

    public List<E> bypassMiddle() {
        if (root == null) {
            throw new RuntimeException("Root is empty!");
        }

        List<E> list = new LinkedList<>();

        if (isHasLeftChild(root)) {
            bypassMiddle(root.left, list);
        }

        list.add(root.value);

        if (isHasRightChild(root)) {
            bypassMiddle(root.right, list);
        }

        return list;
    }

    private void bypassMiddle(Node<E> current, List<E> list) {
        if (current == null) {
            return;
        }

        if (isHasLeftChild(current)) {
            bypassMiddle(current.left, list);
        }

        list.add(current.value);

        if (isHasRightChild(current)) {
            bypassMiddle(current.right, list);
        }
    }

    public List<E> bypassReverse() {
        if (root == null) {
            throw new RuntimeException("Root is empty!");
        }

        List<E> list = new LinkedList<>();

        if (isHasLeftChild(root)) {
            bypassReverse(root.left, list);
        }

        if (isHasRightChild(root)) {
            bypassReverse(root.right, list);
        }

        list.add(root.value);

        return list;
    }

    private void bypassReverse(Node<E> current, List<E> list) {
        if (current == null) {
            return;
        }

        if (isHasLeftChild(current)) {
            bypassReverse(current.left, list);
        }

        if (isHasRightChild(current)) {
            bypassReverse(current.right, list);
        }

        list.add(current.value);
    }

    public List<E> bypassTree() {
        if (root == null) {
            throw new RuntimeException("Root is empty!");
        }

        List<E> valueList = new LinkedList<>();
        Queue<Node<E>> nodeList = new LinkedList<>();
        valueList.add(root.value);

        if (isHasLeftChild(root)) {
            valueList.add(root.left.value);
            nodeList.add(root.left);
        }

        if (isHasRightChild(root)) {
            valueList.add(root.right.value);
            nodeList.add(root.right);
        }

        bypassTree(valueList, nodeList);

        return valueList;
    }

    private void bypassTree(List<E> valueList, Queue<Node<E>> nodeList) {
        if (nodeList.isEmpty()) {
            return;
        }

        Queue<Node<E>> newNodeList = new LinkedList<>();
        for (Node<E> n : nodeList) {
            if (isHasLeftChild(n)) {
                valueList.add(n.left.value);
                newNodeList.add(n.left);
            }

            if (isHasRightChild(n)) {
                valueList.add(n.right.value);
                newNodeList.add(n.right);
            }
        }

        bypassTree(valueList, newNodeList);
    }


    private int compare(E o1, E o2) {
        return comparator == null
                ? ((Comparable<? super E>) o1).compareTo(o2)
                : comparator.compare(o1, o2);
    }

    private static class Node<E> {
        private E value;

        private Node<E> left;
        private Node<E> right;

        public Node(Node<E> left, E value, Node<E> right) {
            this.left = left;
            this.value = value;
            this.right = right;
        }

        public Node(E value) {
            this(null, value, null);
        }

        public E getValue() {
            return value;
        }
    }
}
