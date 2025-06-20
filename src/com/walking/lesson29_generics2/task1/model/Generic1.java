package com.walking.lesson29_generics2.task1.model;

public class Generic1<T> {
    private T field;

    public Generic1() {
    }

    public Generic1(T field) {
        this.field = field;
    }

    public T getField() {
        return field;
    }
}
