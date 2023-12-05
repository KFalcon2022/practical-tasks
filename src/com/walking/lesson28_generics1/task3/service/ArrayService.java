package com.walking.lesson28_generics1.task3.service;

public class ArrayService<T> {
    private final T[] items;

    public ArrayService(T[] items) {
        this.items = items;
    }

    public T searchElement(T searchItem) {
        for (T item : items) {
            if (item.equals(searchItem)) {
                return searchItem;
            }
        }
        throw new SecurityException();
    }
}
