package com.walking.lesson37_collection_list.task2.collection;

import java.util.Collection;
import java.util.Iterator;

public class MyCollection<E> implements Collection<E> {
    private Element<E> top;
    private int size;

    public MyCollection() {
    }

    public MyCollection(E top) {
        this.top = new Element<>(top);
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
        Element<E> el = top;

        while (el != null) {
            if (o.equals(el.value)) {
                return true;
            }
            el = el.previous;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] elements = new Object[size];
        Element<E> lastElement = top;
        for (int i = size - 1; i >= 0; i--) {
            elements[i] = lastElement.value;
            lastElement = lastElement.previous;
        }

        return elements;
    }

    @Override
    public boolean add(E el) {
        Element<E> newTop = new Element<>(top, el);
        size++;
        top = newTop;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        }

        if (o.equals(top)) {
            top = top.previous;
            size--;
            return true;
        }

        Element<E> el = top;
        int i = 1;
        while (i < size) {
            if (o.equals(el.previous.value)) {
                el.previous = el.previous.previous;
                size--;
                return true;
            }
            el = el.previous;
            i++;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) {
            return false;
        }

        for (E e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        top = null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c.isEmpty()) {
            return false;
        }

        while (!c.contains(top.value)) {
            top = top.previous;
            size--;
        }

        Element<E> el = top;
        while (el != null) {
            if (!c.contains(el.previous.value)) {
                el.previous = el.previous.previous;
                size--;
            }
            el = el.previous;
        }

        return size > 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.isEmpty()) {
            return false;
        }

        boolean isRemoved = false;
        for (Object e : c) {
            if (remove(e)) {
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if(!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return a;
    }

    private static class Element<E> {
        private final E value;
        private Element<E> previous;

        private Element(E top) {
            this.value = top;
        }

        private Element(Element<E> previous, E top) {
            this.value = top;
            this.previous = previous;
        }
    }
}
