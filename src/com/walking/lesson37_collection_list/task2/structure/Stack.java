package com.walking.lesson37_collection_list.task2.structure;

import com.walking.lesson37_collection_list.task2.exception.ElementNotFoundException;

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Stack<E> implements Collection<E> {
    private Node<E> top;
    private int size;

    public Stack() {
    }

    public Stack(E topValue) {
        this.top = new Node<>(topValue);
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
    public boolean contains(Object object) {
        Node<E> current = top;

        while (current != null) {
            if (Objects.equals(object, current.value)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    @Override
    public boolean add(E element) {
        top = new Node<>(element, top);
        size++;

        return true;
    }

    @Override
    public boolean remove(Object object) {
        if (Objects.equals(top.value, object)) {
            top = top.next;
            size--;

            return true;
        }

        Node<E> current = top;

        while (current.next != null) {
            if (Objects.equals(current.next.value, object)) {
                current.next = current.next.next;
                size--;

                return true;
            }

            current = current.next;
        }

        throw new ElementNotFoundException();
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (current == null) {
                    throw new NoSuchElementException("iterator has no more elements");
                }

                Node<E> temp = current;
                current = current.next;

                return temp.value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] values = new Object[size];
        Node<E> current = top;

        for (int i = 0; i < values.length; i++) {
            values[i] = current.value;
            current = current.next;
        }

        return values;
    }

    @Override
    public <T> T[] toArray(T[] array) {
        Node<E> current = top;

        if (array.length < size) {
            array = Arrays.copyOf(array, size);
        }

        for (int i = 0; i < size; i++) {
            array[i] = (T) current.value;
            current = current.next;
        }

        return array;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object object : collection) {
            if (!this.contains(object)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        for (E element : collection) {
            this.add(element);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (this.containsAll(collection)) {
            for (Object object : collection) {
                this.remove(object);
            }

            return true;
        }

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        for (E element : this) {
            if (!collection.contains(element)) {
                this.remove(element);
            }
        }
        return false;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        throw new UnsupportedOperationException("toArray(IntFunction<T[]> generator)");
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        throw new UnsupportedOperationException("removeIf");
    }

    @Override
    public Spliterator<E> spliterator() {
        throw new UnsupportedOperationException("spliterator");
    }

    @Override
    public Stream<E> stream() {
        throw new UnsupportedOperationException("stream");
    }

    @Override
    public Stream<E> parallelStream() {
        throw new UnsupportedOperationException("parallelStream");
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(",", "TOP -> ", " (size = " + size + ")");

        Node<E> current = top;

        while (current != null) {
            result.add(current.value.toString());
            current = current.next;
        }

        return result.toString();
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
}
