package com.walking.lesson28_generics1.task3;

public class ArrayClass<T> {
    private T[] item;

    public ArrayClass(T[] item) {
        this.item = item;
    }

    public T[] getArray() {
        return item;
    }

    public T findItem(T value) {
        for (T i : item) {
            if (i.equals(value)) {
                return i;
            }
        }
        throw new RuntimeException("nothing");
    }

}
