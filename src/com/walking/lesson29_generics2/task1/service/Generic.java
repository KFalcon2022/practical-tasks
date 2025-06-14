package com.walking.lesson29_generics2.task1.service;

public class Generic<T> {
    private final T object;

    public Generic(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }
}
