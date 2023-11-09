package com.walking.lesson37_collection_list.task2.structure;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class Stack<T> implements Collection<T> {
    private Node top;
    private int size;

    public Stack() {
    }

    public Stack(T top) {
        this.top = new Node<>(top);
        size++;
    }

    public boolean add(T element) {
        top = new Node<>(element, top);
        size++;
        return true;
    }

    public T search(T element) {
        return contains(element) ? element : null;
    }

    public boolean remove(Object element) {
        Node<T> temp = top;

        if (top.value.equals(element)) {
            top = top.next;
            size--;

            return true;
        }

        while (temp.next != null) {
            if (Objects.equals(element, temp.next.value)) {
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        for (var element : c) {
            add((T) element);
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        Node<T> temp = top;
        boolean isValueCollection;

        while (temp.next != null) {
            isValueCollection = false;
            for (var element : c) {
                if (Objects.equals(element, temp.next.value)) {
                    isValueCollection = false;
                    break;
                } else {
                    isValueCollection = true;
                }
            }
            if (isValueCollection) {
                remove(temp.next.value);
            } else {
                temp = temp.next;
            }
        }

        isValueCollection = true;
        for (var element : c) {
            if (top.value.equals(element)) {
                isValueCollection = false;
            }
        }

        if (isValueCollection) {
            remove(top.value);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection c) {

        for (var element : c) {
            remove((T) element);
        }

        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (var element : c) {
            if (!contains((T) element)) {
                return false;
            }
        }

        return true;
    }

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

        if (top.value.equals(o)) {
            return true;
        }

        while (temp.next != null) {
            if (temp.next.value.equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size];
        Node temp = top;

        if (temp == null) {
            return objects;
        }

        StringBuilder result = new StringBuilder();
        result.append("[");

        for (int i = 0; i < size - 1; i++) {
            objects[i] = temp.value;
            temp = temp.next;
        }

        objects[size-1] = temp.value;

        return objects;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public String toString() {
        Node temp = top;

        if (temp == null) {
            return "Stack is empty";
        }

        StringBuilder result = new StringBuilder();
        result.append("[");

        for (int i = 0; i < size - 1; i++) {
            result.append(temp.value + ", ");
            temp = temp.next;
        }

        result.append(temp.value + "]");

        return result.toString();
    }

    private class Node<T> {
        private final T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
