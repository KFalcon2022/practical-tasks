package com.walking.lesson28_generics1.task2;

public class SomeType<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public Boolean isNull() {
        return this.value == null;
    }
}
