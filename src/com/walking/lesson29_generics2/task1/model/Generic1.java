package com.walking.lesson29_generics2.task1.model;

public class Generic1<T> {
    private final T number;

    public Generic1(T field) {
        this.number = field;
    }

    public T getNumber() {
        return number;
    }
}
