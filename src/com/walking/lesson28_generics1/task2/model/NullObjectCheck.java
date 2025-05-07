package com.walking.lesson28_generics1.task2.model;

public class NullObjectCheck<T> {
    private final T object;

    public NullObjectCheck(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public boolean isNull() {
        return object == null;
    }
}
