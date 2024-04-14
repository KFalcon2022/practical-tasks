package com.walking.lesson28_generics1.task3;

public class ArrayClass<T> {
    private final T[] values;

    public ArrayClass(T[] values) {
        this.values = values;
    }

    public T findElement(T t) {
        for (T value : values) {
            if (value.equals(t)) {
                return value;
            }
        }
        throw new ElementNotFoundException();
    }

}
