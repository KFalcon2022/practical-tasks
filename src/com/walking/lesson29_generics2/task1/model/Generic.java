package com.walking.lesson29_generics2.task1.model;

public class Generic<T> {
    private final T number;

    public Generic(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }
}
