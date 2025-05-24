package com.walking.lesson28_generics1.task3.service;

import com.walking.lesson28_generics1.task3.exception.ValueNotFoundException;

public class ValueSearcher<T> {
    private final T[] array;

    public ValueSearcher(T[] array) {
        this.array = array;
    }

    public T search(T requiredValue) {

        for (T arrayValue : array) {
            if (arrayValue.equals(requiredValue)) {
                return arrayValue;
            }
        }

        throw new ValueNotFoundException();
    }
}
