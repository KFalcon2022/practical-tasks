package com.walking.lesson29_generics2.task1;

public class Generic<T> {
    private final T object;

    public T getObject() {
        return object;
    }

    public Generic(T object) {
        this.object = object;
    }
}
