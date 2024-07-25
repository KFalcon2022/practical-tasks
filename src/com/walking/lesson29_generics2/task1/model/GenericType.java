package com.walking.lesson29_generics2.task1.model;

public class GenericType <T>{
    private final T object;

    public GenericType(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }
}
