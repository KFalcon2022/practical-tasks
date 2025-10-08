package com.walking.lesson29_generics2.task1.generics;

public class Generic1<T> {
    private final T field;

    public Generic1(T field) {
        this.field = field;
    }

    public T getField() {
        return field;
    }
}
