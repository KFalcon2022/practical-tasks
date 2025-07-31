package com.walking.lesson39_queue1.collection;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class DoublyLinkedList<E> implements Collection<E> {
    private Node<E> top;
    private Node<E> last;

    private int size;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(E e) {
        this.top = new Node<>(e);
        last = top;
        size++;
    }

    public void reverse() {
        if (size <= 1) {
            return;
        }

        last = top;

        Node<E> current = top;
        Node<E> temp = null;
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
        return new DoublyLinkedListIterator<>(top);
    }

    @Override
    public @NotNull Object @NotNull [] toArray() {
        Node<E> temp = top;
        Object[] arr = new Object[size];

        for (int i = 0; i < size; i++) {
            arr[i] = temp.value;
            temp = temp.next;
        }

        return arr;
    }

    @Override
    public @NotNull <T> T @NotNull [] toArray(@NotNull T @NotNull [] a) {
        return (T[]) Arrays.copyOf(toArray(), size, a.getClass());
    }

    @Override
    public boolean add(E e) {
        return addLast(e);
    }

    private boolean addLast(E e) {
        Node<E> oldLast = last;
        Node<E> newLast = new Node<>(oldLast, e, null);
        last = newLast;

        if (oldLast == null) {
            top = newLast;
        } else {
            oldLast.next = newLast;
        }

        size++;

        return true;
    }

    public boolean addTop(E e) {
        Node<E> oldTop = top;
        Node<E> newTop = new Node<>(null, e, oldTop);
        top = newTop;

        if (oldTop == null) {
            last = newTop;
        } else {
            oldTop.prev = newTop;
        }

        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (Objects.equals(o, top.value)) {
            top = top.next;
            size--;

            if (top == null) {
                last = null;

                return true;
            }

            Node<E> temp = top;

            while (temp.next != null) {
                if (Objects.equals(o, temp.next.value)) {
                    temp.next = temp.next.next;
                    size--;

                    if (temp.next == null) {
                        last = null;
                    }

                    return true;
                }

                temp = temp.next;
            }
        }

        return false;
    }

    public void removeTop() {
        if (size == 0) {
            return;
        }

        top = top.next;
        size--;

        if (top == null) {
            last = null;
        }
    }

    public void removeLast() {
        if (size == 0) {
            return;
        }

        last = last.prev;
        size--;

        if (last == null) {
            top = null;
        }
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
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
        boolean result = false;

        for (Object e : c) {
            if (remove(e)) {
                result = true;
            }
        }

        return result;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        if (!c.contains(top.value)) {
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
        last = null;

        size = 0;
    }

    private static class Node<E> {
        private final E value;

        private Node<E> prev;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private static class DoublyLinkedListIterator<E> implements Iterator<E> {
        private Node<E> current;

        public DoublyLinkedListIterator(Node<E> next) {
            current = next;
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
