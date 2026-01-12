package com.walking.lesson28_generics1.task2.model;

public class GenericObject<T> {
    private final T obj;

    public GenericObject(T obj) {
        this.obj = obj;
    }

    public boolean isNull() {
        return obj == null;
    }

    public T get() {
        return obj;
    }
}
