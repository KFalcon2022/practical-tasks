package com.walking.lesson29_generics2.task1.model;

public class Generic<T> {
    private final T object;

    public Generic(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }
}
