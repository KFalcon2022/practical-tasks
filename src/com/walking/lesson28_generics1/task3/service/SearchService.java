package com.walking.lesson28_generics1.task3.service;

import com.walking.lesson28_generics1.task3.exception.ElementNotFoundException;

import java.util.Objects;

public class SearchService<T> {
    private final T[] array;

    public SearchService(T[] array) {
        this.array = array;
    }

    public T find(T searchingValue) {
        for (T element : array) {
            if (Objects.equals(element, searchingValue)) {
                return element;
            }
        }

        throw new ElementNotFoundException();
    }
}
