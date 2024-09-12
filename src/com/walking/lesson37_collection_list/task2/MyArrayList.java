package com.walking.lesson37_collection_list.task2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyArrayList<E> implements Collection {
    private Object[] array;
    private int size;

    public MyArrayList() {
        this.array = new Object[10];
        size = 0;
    }

    public MyArrayList(int capacity) {
        this.array = new Object[capacity];
        size = 0;
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
        for (Object obj : array) {
            return obj.equals(o);
        }

        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public boolean add(Object o) {
        if (size == array.length) {
            grow();
        }

        array[size] = o;
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                array[i] = null;
                System.arraycopy(array, i + 1, array, i, size - i + 1);
                size--;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

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
        return new Object[0];
    }

    @Override
    public String toString() {
        StringBuilder arrayToString = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            arrayToString.append(array[i]);
            arrayToString.append(" ");
        }

        return String.valueOf(arrayToString);
    }

    private void grow() {
        Object[] newArray = array;
        array = new Object[(int) (array.length * 1.5)];
        System.arraycopy(newArray, 0, array, 0, newArray.length);
    }
}
