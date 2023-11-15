package com.walking.lesson42_tree.task1.model;

import java.util.*;

public class MyTree<T> {
    private final Comparator<T> comparator;

    private Node<T> rootNode = null;
    private int size = 0;

    public MyTree() {
        this.comparator = null;
    }

    public MyTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Node<T> getRoot() {
        return rootNode;
    }

    public int getSize() {
        return size;
    }

    public boolean add(T elem) {
        if (rootNode == null) {
            rootNode = new Node<>(elem);
            size++;
            return true;
        }

        Node<T> currentNode = rootNode;
        while (true) {
            //если меньше или равен 0, то elem меньше или равен значению узла и уходит влево
            if (compare(elem, currentNode.getValue()) <= 0) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(new Node(null, elem, null, currentNode));
                    size++;
                    return true;
                } else {
                    currentNode = currentNode.getLeft();
                }
            } else {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(new Node(null, elem, null, currentNode));
                    size++;
                    return true;
                } else {
                    currentNode = currentNode.getRight();
                }
            }
        }
    }

    public T remove(T elem) {
        Node<T> removedElem = search(elem);

        if (rootNode == null || removedElem == null) {
            return null;
        }

        //если удаляемый элемент лист
        if (removedElem.getRight() == null && removedElem.getLeft() == null) {
            //определяем в какой ветви удаляемый элемент,
            // чтобы заменить у его родителя левый или правый узел на null
            if (isLeftNode(removedElem)) {
                removedElem
                        .getParent()
                        .setLeft(null);
            } else {
                removedElem
                        .getParent()
                        .setRight(null);
            }

            size--;
        }

        //если у удаляемого элемента только левый потомок
        if (removedElem.getLeft() != null && removedElem.getRight() == null) {
            //левому потомку удаляемого элемента устанавливаем родителем родителя удаляемого элемента
            removedElem
                    .getLeft()
                    .setParent(removedElem.getParent());

            if (isLeftNode(removedElem)) {
                //родителю удаляемого элемента устанавливаем потомком слева (т.к. сам удаляемый элемент у родителя слева)
                //потомка удаляемого элемента (он у него только левый)
                removedElem
                        .getParent()
                        .setLeft(removedElem.getLeft());
            } else {
                //родителю удаляемого элемента устанавливаем потомком справа (т.к. сам удаляемый элемент у родителя справа)
                //потомка удаляемого элемента (он у него только левый)
                removedElem
                        .getParent()
                        .setRight(removedElem.getLeft());
            }

            size--;
        }

        //если у удаляемого элемента только правый потомок
        if (removedElem.getRight() != null && removedElem.getLeft() == null) {
            removedElem
                    .getRight()
                    .setParent(removedElem.getParent());

            if (isLeftNode(removedElem)) {
                removedElem
                        .getParent()
                        .setLeft(removedElem.getRight());
            } else {
                removedElem
                        .getParent()
                        .setRight(removedElem.getRight());
            }

            size--;
        }

        //если у удаляемого элемента оба потомка
        if (removedElem.getRight() != null && removedElem.getLeft() != null) {
            //ищем большего из потомков
            Node<T> max = max(removedElem);
            max.setParent(removedElem.getParent());

            //левого потомка max сохраняем, чтобы прицепить его (левого потомка) потомком к его (max) правому потомку
            Node<T> temp = max.getLeft();

            if (isLeftNode(removedElem)) {
                removedElem
                        .getParent()
                        .setLeft(max);
            } else {
                removedElem
                        .getParent()
                        .setRight(max);
            }
            //здесь устанавливаем в левую ветку нового узла левую ветку удаляемого элемента
            max.setLeft(removedElem.getLeft());
            //здесь устанавливаем в правую ветку нового узла потомка (левую ветку
            max.getRight().setLeft(temp);

            size--;
        }

        return elem;
    }

    public void walkDeep(Node<T> node) {
        if (node != null) {
            System.out.println(node.getValue());
            walkDeep(node.getLeft());
            walkDeep(node.getRight());
        }
    }

    public void walkWidth(Node<T> node) {
        Queue<Node<T>> q = new LinkedList<>();
        q.add(node);

        Node<T> currentNode;
        if (node != null) {
            while (!q.isEmpty()) {
                currentNode = q.poll();

                System.out.println(currentNode.getValue());

                if (currentNode.getLeft() != null) {
                    q.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    q.add(currentNode.getRight());
                }
            }
        }
    }

    private Node<T> search(T elem) {
        if (rootNode.getValue().equals(elem)) {
            return rootNode;
        }

        Node<T> currentNode = rootNode;
        while (!Objects.equals(elem, currentNode.getValue())) {
            if (compare(elem, currentNode.getValue()) < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }

        if (Objects.equals(elem, currentNode.getValue())) {
            return currentNode;
        }

        return null;
    }

    //здесь я подсмотрел в разбор задач, не мог понять, как мне сказать дереву, что принимать нужно
    //либо объекты реализующие Comparable, либо быть с компаратором
    private int compare(T o1, T o2) {
        return comparator == null
                ? ((Comparable<T>) o1).compareTo(o2)
                : comparator.compare(o1, o2);
    }

    //левый или правый узел у родителя
    private boolean isLeftNode(Node<T> elem) {
        if (Objects.equals(elem.getParent().getLeft(), elem)) {
            return true;
        } else {
            return false;
        }
    }

    //ищет больший из двух потомков узла
    private Node<T> max(Node<T> node) {
        if (compare(node.getLeft().getValue(), node.getRight().getValue()) > 0) {
            return node.getLeft();
        } else {
            return node.getRight();
            }
    }

    private static class Node<T> {
        private Node<T> left = null;
        private final T value;
        private Node<T> right = null;
        private Node<T> parent;

        private Node(T value) {
            this.value = value;
        }

        private Node(Node<T> left, T value, Node<T> right, Node<T> parent) {
            this.left = left;
            this.value = value;
            this.right = right;
            this.parent = parent;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> rigth) {
            this.right = rigth;
        }
    }

}
