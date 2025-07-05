package com.walking.lesson28_generics1.task2.model;

public class NotNullObject<T> {
    private final T object;

    public NotNullObject(T object) {
        this.object = object;
    }

    public boolean isNull() {
        return object == null;
    }

    public T getObject() {
        return object;
    }
}
