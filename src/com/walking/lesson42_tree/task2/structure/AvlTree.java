package com.walking.lesson42_tree.task2.structure;

import java.util.Comparator;

public class AvlTree<T> {
    private Node<T> root;

    private Comparator<T> comparator;

    public AvlTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public AvlTree() {

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
            System.out.print("Проверяем, что можем сравнивать объекты в рамках дерева\n");
            compare(value, value);
        }

        System.out.printf("Добавляем элемент %s\n", value);
        root = add(value, root);
    }

    public void remove(T value) {
        System.out.printf("Удаляем элемент %s\n", value);
        root = remove(value, root);
    }

    private int getHeight(Node<T> node) {
        return node == null ? 0 : node.height;
    }

    private Node<T> add(T value, Node<T> node) {
        if (node == null) {
            System.out.printf("%s добавлен\n", value);
            return new Node<>(value);
        }

        if (compare(value, node.value) <= 0) {
            System.out.printf("%s <= %s, добавление произойдет в левое поддерево\n", value, node.value);
            node.left = add(value, node.left);
        } else {
            System.out.printf("%s > %s, добавление произойдет в правое поддерево\n", value, node.value);
            node.right = add(value, node.right);
        }

        return balance(node);
    }

    private Node<T> remove(T value, Node<T> node) {
        if (node == null) {
            System.out.print("В дереве(поддереве) нет элементов, удалять нечего\n");
            return node;
        }

        Node<T> result = node;
        int compareResult = compare(value, node.value);

        if (compareResult < 0) {
            System.out.printf("%s <= %s, удаление произойдет в левом поддереве\n", value, node.value);
            node.left = remove(value, node.left);
        } else if (compareResult > 0) {
            System.out.printf("%s > %s, удаление произойдет в правом поддереве\n", value, node.value);
            node.right = remove(value, node.right);
        } else if (node.left != null && node.right != null) {
            System.out.print("Удаляемый элемент существует. У него 2 потомка\n");
            System.out.print("Самый правый элемент левого поддерева встанет вместо удаляемого.\n" +
                    "Оригинальный узел нового элемента будет удален\n");
            node.value = findMax(node.left).value;
            node.left = remove(node.value, node.left);

            System.out.print("Элемент удален\n");
        } else {
            result = node.left != null ? node.left : node.right;
            if (result == null) {
                System.out.println("Удаляемый элемент существует и является листом");
            } else {
                System.out.printf("Удаляемый элемент существует. У него существует только %s потомок\n",
                        compare(result.value, value) > -1 ? "левый" : "правый");
            }

            System.out.print("Элемент удален\n");
        }
        return balance(result);
    }

    private Node<T> balance(Node<T> node) {
        System.out.print("Проверяем необходимость балансировки\n");

        if (node == null) {
            System.out.print("Дерево было пустым, балансировка не нужна\n");
            return null;
        }

        int imbalance = getHeight(node.left) - getHeight(node.right);
        Node<T> result = node;

        if (imbalance > 1) {
            System.out.printf("Левое поддерево больше правого на %d. Требуется поворот вправо\n", imbalance);
            result = getHeight(node.left.left) >= getHeight(node.left.right)
                    ? rotateRight(node)
                    : rotateBigRight(node);
        } else if (imbalance < -1) {
            System.out.printf("Правое поддерево больше левого на %d. Требуется поворот влево\n", -imbalance);
            result = getHeight(node.right.right) >= getHeight(node.right.left)
                    ? rotateLeft(node)
                    : rotateBigLeft(node);
        } else {
            System.out.printf("Небаланс составляет %d, балансировка не требуется\n", imbalance);
        }

        result.height = Math.max(getHeight(result.left), getHeight(result.right)) + 1;
        return result;
    }

    private Node<T> rotateRight(Node<T> root) {
        System.out.printf("Малый поворот вправо для %s\n", root.value);

        Node<T> leftChild = root.left;
        root.left = leftChild.right;
        leftChild.right = root;

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        leftChild.height = Math.max(getHeight(leftChild.left), root.height) + 1;

        return leftChild;
    }

    private Node<T> rotateLeft(Node<T> root) {
        System.out.printf("Малый поворот влево для %s\n", root.value);
        Node<T> rightChild = root.right;
        root.right = rightChild.left;
        rightChild.left = root;

        root.height = Math.max(getHeight(root.right), getHeight(root.left)) + 1;
        rightChild.height = Math.max(getHeight(rightChild.right), root.height) + 1;
        return rightChild;
    }

    private Node<T> rotateBigRight(Node<T> root) {
        System.out.printf("Большой поворот вправо для %s\n", this.root.value);
        root.left = rotateLeft(root.left);
        return rotateRight(root);
    }

    private Node<T> rotateBigLeft(Node<T> root) {
        System.out.printf("Большой поворот влево для %s\n", this.root.value);
        root.right = rotateRight(root.right);
        return rotateLeft(root);
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
        private int height;

        public Node(T value) {
            this(value, null, null);
        }

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.height = 0;
        }

    }
}
