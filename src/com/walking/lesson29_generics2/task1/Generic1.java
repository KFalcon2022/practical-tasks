package com.walking.lesson29_generics2.task1;

public class Generic1<T> {
    private T field;

    public T getField() {
        return field;
    }

    public Generic1(T field) {
        this.field = field;
    }
}
