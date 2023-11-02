package com.walking.lesson39_queue1.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class DoubleLinkedList<T> implements Collection<T> {
    private Node<T> top;
    private Node<T> last;
    private int size;

    public DoubleLinkedList() {
    }

    public DoubleLinkedList(T elem) {
        this.top = new Node<>(elem);
        this.last = this.top;
        this.size++;
    }

    public T getTop() {
        return top.value;
    }

    public T getLast() {
        return last.value;
    }

    //я это не осилил. колдовство какое-то
    public void reverseList() {
        if (size <= 1) {
            return;
        }

        last = top;

        Node<T> current = top;
        Node<T> temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        top = temp.prev;
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
        Node<T> temp = top;
        Object[] array = new Object[size];

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

    @Override
    public boolean add(T t) {
        return addLast(t);
    }

    public boolean addLast(T elem) {
        Node<T> l = last;
        Node<T> node = new Node<>(l, elem, null);
        last = node;

        if (l == null) {
            top = node;
        } else {
            l.next = node;
        }

        size++;

        return true;
    }

    public boolean addTop(T elem) {
        Node<T> t = top;
        Node<T> node = new Node<>(null ,elem, t);
        top = node;

        if (t == null) {
            last = node;
        } else {
            t.prev = node;
        }

        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (size ==0) {
            return false;
        }

        Node<T> temp = top;
        if (o.equals(temp.value)) {
            top = top.next;
            size--;

            return true;
        }

        while (temp.next != null) {
            if (o.equals(temp.next.value)) {
                temp.next = temp.next.next;
                size--;
                return true;
            }

            temp.next = temp.next.next;
        }

        return false;
    }

    public boolean removeTop() {
        if (size == 0) {
            return false;
        }

        Node<T> temp = top.next;
        top = temp;
        size--;

        return true;
    }

    public boolean removeLast() {
        if (size == 0) {
            return false;
        }

        Node<T> temp = last;
        last = temp.prev;
        size--;

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean result = true;

        for (Object elem : c) {
            if (!contains(elem)) {
                result = false;
            }
        }

        return result;
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
        while (!c.contains(top.value)) {
            top = top.next;
            size--;
        }

        Node<T> temp = top;
        while (temp.next != null) {
            if (!c.contains(temp.next)) {
                temp.next = temp.next.next;
                size--;
            }

            temp = temp.next;
        }

        return size > 0;
    }

    @Override
    public void clear() {
        top = null;
        last = null;
        size = 0;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        private Node(T value) {
            this.value = value;
        }

        private Node(Node<T> prev, T value, Node<T> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
