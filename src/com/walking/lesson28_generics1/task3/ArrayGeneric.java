package com.walking.lesson28_generics1.task3;

public class ArrayGeneric<T> {
    private final T[] array;

    public ArrayGeneric(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public T searchValueInArray(T[] array, T searchValue) {
        for (T value : array) {
            if(value.equals(searchValue)) {
                return searchValue;
            } else throw new RuntimeException("Элемент не найден");
        }
        return null;
    }
}
