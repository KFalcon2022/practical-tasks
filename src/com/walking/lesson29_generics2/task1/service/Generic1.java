package com.walking.lesson29_generics2.task1.service;

public class Generic1<T> {
    private final T object;

    public Generic1(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }
}
