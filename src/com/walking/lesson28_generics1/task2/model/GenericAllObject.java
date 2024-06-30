package com.walking.lesson28_generics1.task2.model;

public class GenericAllObject<T> {
    private T object;

    public GenericAllObject(T object) {
        this.object = object;
    }

    public boolean isNull() {
        return object == null;
    }
}
