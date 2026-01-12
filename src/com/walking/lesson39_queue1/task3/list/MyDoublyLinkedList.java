package com.walking.lesson39_queue1.task3.list;

public class MyDoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyDoublyLinkedList() {
    }

    public MyDoublyLinkedList(E el) {
        this.head = new Node<>(el);
        this.tail = head;
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E el) {
        if (isEmpty()) {
            this.head = new Node<>(el);
            this.tail = head;
        } else {
            Node<E> newHead = new Node<>(el, null, head);
            head.prev = newHead;
            head = newHead;
        }
        size++;
    }

    public void addLast(E el) {
        if (isEmpty()) {
            this.head = new Node<>(el);
            this.tail = head;
        } else {
            Node<E> newTail = new Node<>(el, tail, null);
            tail.next = newTail;
            tail = newTail;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }

        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        }

        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
    }

    public void removeAll(E el) {
        while (!isEmpty() && tail.value.equals(el)) {
            removeLast();
        }

        while (!isEmpty() && head.value.equals(el)) {
            removeFirst();
        }

        if (!isEmpty()) {
            Node<E> current = tail;
            Node<E> previous = tail.prev;
            while (previous != null) {
                if (previous.value.equals(el)) {
                    current.prev = previous.prev;
                    current.prev.next = current;
                    size--;
                }
                current = current.prev;
                previous = current.prev;
            }
        }
    }

    public boolean contains(Object o) {
        Node<E> el = tail;

        while (el != null) {
            if (o.equals(el.value)) {
                return true;
            }
            el = el.prev;
        }
        return false;
    }

    public int countOccurrences(E el) {
        Node<E> current = tail;
        int amount = 0;
        while (current != null) {
            if (current.value.equals(el)) {
                amount++;
            }
            current = current.prev;
        }
        return amount;
    }

    public void reverse() {
        Node<E> current = head;
        head = tail;
        tail = current;

        while (current != null) {
            Node<E> temp = current.next;
            current.next = current.prev;
            current.prev = temp;

            current = temp;
        }
    }

    public void removeEvenHashCodes() {
        if (isEmpty()) {
            return;
        }

        while (!isEmpty() && tail.hashCode() % 2 == 0) {
            removeLast();
        }

        while (!isEmpty() && head.hashCode() % 2 == 0) {
            removeFirst();
        }

        Node<E> current = tail;
        while (current != null) {
            if (current.hashCode() % 2 == 0) {
                current.next.prev = current.prev;
                current.prev.next = current.next;
                size--;
            }
            current = current.prev;
        }

    }

    public String toString() {
        StringBuilder allElements = new StringBuilder();
        Node<E> el = head;

        while (el != null) {
            allElements.append(el.value);
            if (el.next != null) {
                allElements.append(", ");
            }
            el = el.next;
        }
        return allElements.toString();
    }

    public Object getHeadValue() {
        return head.value;
    }

    public Object getTailValue() {
        return tail.value;
    }

    private static class Node<E> {
        private final E value;
        Node<E> prev;
        Node<E> next;

        private Node(E value) {
            this.value = value;
        }

        private Node(E value, Node<E> prev, Node<E> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
