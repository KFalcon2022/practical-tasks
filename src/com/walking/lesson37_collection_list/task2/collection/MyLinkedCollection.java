package com.walking.lesson37_collection_list.task2.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyLinkedCollection<T> implements Collection<T> {
    private Node<T> top;
    private int size;

    public MyLinkedCollection() {
    }

    public MyLinkedCollection(T elem) {
        this.top = new Node<>(elem);
        size++;
    }

    public T getElem() {
        return top.value;
    }

    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        return null;
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return false;
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public Stream<T> stream() {
        return null;
    }

    @Override
    public Stream<T> parallelStream() {
        return null;
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

        while(temp != null) {
            if (temp.value.equals(o)) {
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

    @Override
    public boolean add(T t) {
        top = new Node<>(t, top);
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> temp = top;

        if (o.equals(top.value)) {
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
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;

        for (Object o : c) {
            remove(o);

            result = true;
        }
        return result;
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

    private static class Node<T> {
        private final T value;
        private Node next;

        private Node(T value) {
            this.value = value;
        }

        private Node(T value, Node<T> node) {
            this.value = value;
            this.next = node;
        }
    }
}
