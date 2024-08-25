package com.walking.lesson29_generics2.task1;

public class Generic<T> {
    private T field;

    public Generic(T field) {
        this.field = field;
    }

    public T getField() {
        return field;
    }
}
