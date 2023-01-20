package com.walking.lesson39.Test1;

import java.util.function.Predicate;

/**
 * Это реализация списка, безотносительно queue, stack или что-то еще.
 * Поэтому принимает T, возвращает T
 */

public class MyList<T> {
    private Node<T> head;

    public MyList() {
        this.head = null;
    }

    public void add(T data) {
        Node<T> item = new Node(data);
        Node<T> node = head;
        while (node != null && node.next != null) {
            node = node.next;
        }
        if (node == null) {
            head = item;
        } else {
            node.next = item;
        }
    }

    public T get(Node<T> node) {
        return node.data;
    }

    public Node<T> getFirstNode() {
        return head;
    }

    public void reverse() {
        if (head == null) {
            return;
        }
        Node<T> prevElement = head;
        Node<T> nextElement = prevElement.next;
        prevElement.next = null;
        while (nextElement != null) {
            Node<T> temp = nextElement.next;
            nextElement.next = prevElement;
            prevElement = nextElement;
            head = nextElement;
            nextElement = temp;
        }
        // в разборе посмотрю, как реализовать проще
    }

    public void filter(Predicate<Node<T>> predicate) {
        if (head == null) {
            return;
        }
        Node<T> element = head;
        Node<T> prevElement = null;
        while (element != null) {
            if (predicate.test(element)) {
                // первый
                if (head == element) {
                    head = element.next;
                }
                // последний
                else if (element.next == null) {
                    if (prevElement != null) {
                        prevElement.next = null;
                    }
                }
                // все остальные
                else {
                    prevElement.next = element.next;
                }
            } else {
                prevElement = element;
            }
            element = element.next;
        }
    }

    public class Node<T> {
        public Node<T> next;

        public final T data;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public int hashCode() {
            return data.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            if (this == o) {
                return true;
            }
            return this.hashCode() == ((Node)o).hashCode();
        }
    }
}
