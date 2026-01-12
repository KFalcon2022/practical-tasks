package com.walking.lesson28_generics1.task3.model;

public class GenericArray<T> {
    private final T[] arr;

    public GenericArray(T[] arr) {
        this.arr = arr;
    }

    public T[] get() {
        return arr;
    }

    public T find(T object) {
        for (T obj : arr) {
            if (obj.equals(object)) {
                return obj;
            }
        }
        throw new RuntimeException("Элемент не найден");
    }
}
