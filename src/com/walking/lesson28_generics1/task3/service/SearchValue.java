package com.walking.lesson28_generics1.task3.service;

import com.walking.lesson28_generics1.task3.exception.ElementNotFoundException;

public class SearchValue<T> {
    private final T[] value;

    public SearchValue(T[] value) {
        this.value = value;
    }

    public T[] getValue() {
        return value;
    }

    public T searchValue(T element) {
        for (T value : value) {
            if (value.equals(element)) {
                return value;
            }
        }

        throw new ElementNotFoundException();
    }
}
