package com.walking.lesson29_generics2.task1.model;

public class CustomGeneric<T> {
    private final T field;

    public CustomGeneric(T field) {
        this.field = field;
    }

    public T getField() {
        return field;
    }

    @Override
    public String toString() {
        return field.toString();
    }
}
