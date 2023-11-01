package com.walking.lesson39_queue1.collection;

import com.walking.lesson39_queue1.exception.NoElementException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class SinglyLinkedList<T> implements Collection<T> {
    private Node<T> top;
    private int size;

    public SinglyLinkedList() {
    }
    public SinglyLinkedList(T elem) {
        this.top = new SinglyLinkedList.Node<>(elem);
        size++;
    }

    public T getTop() {
        return top.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> temp = top;
        while (temp != null) {
            if (o.equals(temp.value)) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> temp = top;

        int i = 0;
        while (temp != null) {
            array[i] = temp.value;
            temp = temp.next;
            i++;
        }

        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return (T1[]) Arrays.copyOf(toArray(), size, a.getClass());
    }

    public boolean add(T elem) {
        top = new SinglyLinkedList.Node<>(elem, top);
        size++;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> temp = top;

        if (top.value.equals(o)) {
            top = top.next;
            size--;

            return true;
        }

        while (temp.next != null) {
            if (temp.next.value.equals(o)) {
                temp.next = temp.next.next;
                size--;

                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object elem : c) {
            if (!contains(elem)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T elem : c) {
            add(elem);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object elem : c) {
            remove(elem);
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        while (c.contains(top.value)) {
            top = top.next;
            size--;
        }

        Node<T> temp = top;
        while (temp.next != null) {
            if (c.contains(temp.next)) {
                temp.next = temp.next.next;
                size--;
            }
            temp = top.next;
        }

        return size > 0;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    public T find(T elem) {
        SinglyLinkedList.Node<T> temp = top;

        while (temp != null) {
            if (elem.equals(temp.value)) {
                return elem;
            }
            temp = temp.next;
        }

        throw new NoElementException();
    }

    public void delete(T elem) {
        Node<T> temp = top;

        if (elem.equals(top.value)) {
            top = top.next;
            size--;

            return;
        }

        while (temp.next != null) {
            if (elem.equals(temp.next.value)) {
                temp.next = temp.next.next;
                size--;

                return;
            }

            temp = temp.next;
        }

        throw new NoElementException();
    }

    //тут мой мозг сломался, я подсмотрел, и даже после этого я с трудом туда это запихнул
    public void reverseList() {
        SinglyLinkedList.Node<T> prev = null;
        while (top != null) {
            Node<T> next = top.next;
            top.next = prev;
            prev = top;
            top = next;
        }

        top = prev;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        SinglyLinkedList.Node<T> temp = top;

        while (temp != null) {
            sb.append(temp.value);

            if (temp.next != null) {
                sb.append(", ");
            }

            temp = temp.next;
        }

        sb.append("]");
        return sb.toString();
    }

    private static class Node<T> {
        private final T value;
        private SinglyLinkedList.Node<T> next;

        private Node(T value) {
            this.value = value;
        }

        private Node(T value, SinglyLinkedList.Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
