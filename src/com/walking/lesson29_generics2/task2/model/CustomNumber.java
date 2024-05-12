package com.walking.lesson29_generics2.task2.model;

public class CustomNumber<T extends Number> {
    private final T value;

    public CustomNumber(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
