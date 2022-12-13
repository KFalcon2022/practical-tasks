package com.walking.lesson27_generics.task3.model;

import java.util.NoSuchElementException;

public class ArrayWrapper<T> {

    private final T[] array;

    public ArrayWrapper(T[] array) {
        this.array = array;
    }

    public T findValueInArray(T value) {
        for (T arrayValue : array) {
            if (arrayValue.equals(value)) {
                return arrayValue;
            }
        }
        throw new NoSuchElementException(String.format("The value %s isn't present in the array", value.toString()));
    }
}
