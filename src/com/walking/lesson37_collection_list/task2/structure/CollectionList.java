package com.walking.lesson37_collection_list.task2.structure;

import java.util.*;

public class CollectionList<E> implements Collection<E> {
    private Node<E> top;
    private int size;

    public CollectionList() {
    }

    public CollectionList(E top) {
        this.top = new Node<>(top);
        size++;
    }

    public E getTop() {
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
        Node<E> temp = top;

        while (temp != null) {
            if (Objects.equals(o, temp.value)) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new CollectionListIterator<>(top);
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node<E> temp = top;

        for (int i = 0; i < size; i++) {
            arr[i] = temp.value;
            temp = temp.next;
        }

        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(toArray(), size, a.getClass());
    }

    @Override
    public boolean add(E e) {
        top = new Node<>(e);
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> temp = top;

        if (Objects.equals(o, top.value)) {
            top = top.next;
            size--;

            return true;
        }

        while (temp.next != null) {
            if (Objects.equals(o, temp.next.value)) {
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
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;

        for (Object e : c) {
            if (remove(e)) {
                result = true;
            }
        }

        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        while (!c.contains(top.value)) {
            top = top.next;
            size--;
        }

        Node<E> temp = top;
        while (temp.next != null) {
            if (!c.contains(temp.next.value)) {
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
        size = 0;
    }

    private static class Node<E> {
        private final E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private static class CollectionListIterator<E> implements Iterator<E> {
        private Node<E> current;

        public CollectionListIterator(Node<E> top) {
            current = top;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E result = current.value;
            current = current.next;

            return result;
        }
    }
}
