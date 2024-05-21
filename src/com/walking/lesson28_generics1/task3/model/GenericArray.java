package com.walking.lesson28_generics1.task3.model;

import com.walking.lesson28_generics1.task3.exeption.ValueNotFound;

public class GenericArray<T> {
    private final T[] array;

    public GenericArray(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public T getValue(T value) {
        for (T a : array) {
            if (a.equals(value)) {
                return a;
            }
        }

        throw new ValueNotFound("Значение не найдено.");
    }
}
