package com.walking.lesson28_generics1.task3.utility;

import java.util.Objects;

public class ArrayUtility<T> {
    private final T[] array;

    public ArrayUtility(T[] array) {
        this.array = array;
    }

    public T find(T searchingValue) {
        for (T element : array) {
            if (Objects.equals(element, searchingValue)) {
                return element;
            }
        }

        throw new ElementNotFoundException("Значение не найдено", searchingValue.toString());
    }
}
