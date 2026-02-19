package com.walking.lesson39_queue1.collection;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SinglyLinkedList<E> implements Collection<E> {
    private Node<E> top;
    private int size;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(E element) {
        this.top = new Node<>(element);
        size++;
    }

    public E getTop() {
        return top.value;
    }

    public void reverse() {
        Node<E> prev = null;
        while (top != null) {
            Node<E> next = top.next;
            top.next = prev;
            prev = top;
            top = next;
        }

        top = prev;
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
    public @NotNull Iterator<E> iterator() {
        return new SinglyLinkedListIterator<>(top);
    }

    @Override
    public Object @NotNull [] toArray() {
        Object[] array = new Object[size];
        Node<E> temp = top;

        for (int i = 0; i < size; i++) {
            array[i] = temp.value;
            temp = temp.next;
        }

        return array;
    }

    @Override
    public <T> T @NotNull [] toArray(T @NotNull [] a) {
        return (T[]) Arrays.copyOf(toArray(a), size, a.getClass());
    }

    @Override
    public boolean add(E e) {
        this.top = new Node<>(top, e);
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (Objects.equals(o, top.value)) {
            top = top.next;
            size--;

            return true;
        }

        Node<E> temp = top;

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
    public boolean addAll(@NotNull Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }

        return true;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        boolean removed = false;
        Node<E> temp = top;

        for (Object e : c) {
            if (Objects.equals(temp.value, e)) {
                temp = temp.next;
                size--;

                removed = true;
            }
        }

        return removed;
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
        }

        return size > 0;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    private static class Node<E> {
        private Node<E> next;
        private final E value;

        public Node(E value) {
            this.value = value;
        }

        public Node(Node<E> next, E value) {
            this.next = next;
            this.value = value;
        }
    }

    private static class SinglyLinkedListIterator<E> implements Iterator<E> {
        private Node<E> current;

        public SinglyLinkedListIterator(Node<E> top) {
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
