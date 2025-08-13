package com.walking.lesson39_queue1.task3;


import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class DoubleLinkedList<E> implements Collection<E> {
    private Node<E> first;
    private Node<E> last;

    private int size;

    public DoubleLinkedList() {
    }

    public DoubleLinkedList(E e) {
        first = new Node<>(e);
        last = first;
        size++;
    }

    public E getFirst() {
        return first.value;
    }

    public E getLast() {
        return last.value;
    }

    public void reverseList() {
        Node<E> current = first;
        first = last;

        while (current != null) {
            Node<E> temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = temp;
        }
    }

    public void deleteNodeWithEvenHash() {
        Node<E> current = first;

        while (current != null) {
            if (current.hashCode() % 2 == 0) {
                remove(current.value);
            }
            current = current.next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(Object o) {
        if (isEmpty()) {
            return false;
        }

        Node<E> current = first;

        while (!current.value.equals(o)) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return addLast(e);
    }

    public boolean addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            first = newNode;
            last = first;

        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;


        }
        size++;

        return true;
    }

    public boolean addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            first = newNode;
            last = first;

        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;


        }
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        }

        if (first.value.equals(o)) {
            first = first.next;
            first.prev = null;
            size--;

            return true;
        } else if (last.value.equals(o)) {
            last = last.prev;
            last.next = null;
            size--;

            return true;
        }

        Node<E> current = first;

        while (!current.value.equals(o)) {
            current = current.next;
            if (current == null) {
                System.out.println("There is not element in list!");
                return false;
            }
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        String[] array = new String[size];
        Node<E> current = first;

        for (int i = 0; i < size; i++) {
            array[i] = current.value.toString() + " " + current.hashCode();
            current = current.next;
        }

        return Arrays.toString(array);
    }


    private static class Node<E> {
        private final E value;
        private Node<E> next;
        private Node<E> prev;

        private Node(E value) {
            this.value = value;
        }

    }
}
