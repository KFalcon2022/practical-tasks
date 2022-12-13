package com.walking.lesson28_generics.task2.model;

public class ObjectWrapper<T> {

    private final T object;

    public ObjectWrapper(T object) {
        this.object = object;
    }

    public boolean isNull() {
        return object == null;
    }
}
