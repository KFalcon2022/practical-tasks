package com.walking.lesson29_generics2.task1.model;

public class Generic<T> {
    private final T field;

    public Generic(T value) {
        this.field = value;
    }

    public T getField() {
        return field;
    }
}
