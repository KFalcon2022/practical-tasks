package com.walking.lesson28_generics1.task3.service;

import com.walking.lesson28_generics1.task3.exception.ValueNotFoundException;

public class FindValueArray<T> {
    private final T[] array;

    public FindValueArray(T[] array) {
        this.array = array;
    }

    public T findValue(T value) throws Exception {
        for(T arrValue: array) {
            if (arrValue.equals(value)) {
                return arrValue;
            }
        }
        throw new ValueNotFoundException();
    }
}
