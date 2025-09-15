package com.walking.lesson37_collection_list.task2.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyCollection<E> implements Collection<E> {
    public Object[] elements;
    private int size;


    public MyCollection() {
        elements = new Object[]{};
    }

    public MyCollection(E el) {
        elements = new Object[]{el};
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
        for (Object object : elements) {
            if (o.equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public boolean add(E el) {
        size++;
        elements = Arrays.copyOf(elements, size);
        elements[size - 1] = el;
        return true;
    }

    public boolean remove() {
        return removeByIndex(size - 1);
    }

    @Override
    public boolean remove(Object o) {
        return removeByIndex(getIndex(o));
    }

    public boolean removeByIndex(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        size--;
        Object[] newElements = new Object[size];
        for (int i = 0; i < size; i++) {
            if (i < index) {
                newElements[i] = elements[i];
            }

            if (i > index) {
                newElements[i - 1] = elements[i];
            }
        }
        elements = newElements;
        return true;
    }

    public int getIndex(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] objects = c.toArray();
        int addLength = objects.length;
        if (addLength == 0) {
            return false;
        }

        size += addLength;
        Object[] newElements = new Object[size];
        int indexOb = 0;
        for (int i = 0; i < size; i++) {
            if (i < elements.length) {
                newElements[i] = elements[i];
            } else {
                newElements[i] = objects[indexOb];
                indexOb++;
            }
        }
        elements = newElements;
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        elements = new Object[0];
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return a;
    }
}
