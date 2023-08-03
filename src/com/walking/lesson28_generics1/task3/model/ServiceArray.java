package com.walking.lesson28_generics1.task3.model;

import java.util.Objects;

public class ServiceArray<T> {
    private T[] array;

    public ServiceArray(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public T searchElement(T value) {
        for (T elem : array) {
            if (Objects.equals(elem,value)) {
                return elem;
            }
        }
        throw new ExceptionNotFound();
    }
}
