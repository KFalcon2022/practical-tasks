package com.walking.lesson37_collection_list.task2.collection;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Stack<T> implements Collection<T> {
    private Node<T> top;
    private int size;

    public Stack() {
    }

    public Stack(T top) {
        this.top = new Node<>(top);
        size++;
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
            if (Objects.equals(o, temp.value)) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    @Override
    public @NotNull Iterator<T> iterator() {
        return new StackIterator<>(top);
    }

    @Override
    public @NotNull Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> temp = top;

        for (int i = 0; i < size; i++) {
            array[i] = temp.value;
            temp = temp.next;
        }

        return array;
    }

    @Override
    public @NotNull <E> E[] toArray(@NotNull E[] a) {
        return (E[]) Arrays.copyOf(toArray(), size, a.getClass());
    }

    @Override
    public boolean add(T element) {
        if (top != null) {
            top = new Node<>(element, top);
            size++;

            return true;
        }

        top = new Node<>(element);
        size++;

        return true;
    }


    @Override
    public boolean remove(Object o) {
        if (Objects.equals(o, top.value)) {
            top = top.next;
            size--;
        }

        Node<T> temp = top;
        while (temp.next != null) {
            if (Objects.equals(o, temp.next.value)) {
                temp.next = temp.next.next;
                size++;

                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {
        for (T o : c) {
            add(o);
        }

        return true;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public boolean retainAll(@NotNull Collection c) {
        if (!c.contains(top.value)) {
            top = top.next;
            size--;
        }

        Node<T> temp = top;

        for (Object o : c) {
            while (temp.next != null) {
                if (!c.contains(o)) {
                    temp.next = temp.next.next;
                    size--;
                }
            }
        }

        return size > 0;
    }

    @Override
    public boolean removeAll(@NotNull Collection c) {
        boolean result = false;
        Node<T> temp = top;

        for (Object o : c) {
            if (Objects.equals(o, temp.value)) {
                temp = temp.next;
                size--;

                result = true;
            }
        }

        return result;
    }


    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            next = null;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private static class StackIterator<E> implements Iterator<E> {
        Node<E> current;

        public StackIterator(Node<E> top) {
            current = top;
        }


        @Override
        public boolean hasNext() {
            return current.next != null;
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
