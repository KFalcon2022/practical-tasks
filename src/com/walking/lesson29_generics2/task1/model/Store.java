package com.walking.lesson29_generics2.task1.model;

public class Store<T> {
    private final T instance;

    public Store(T instance) {
        this.instance = instance;
    }

    public T getInstance() {
        return instance;
    }
}
