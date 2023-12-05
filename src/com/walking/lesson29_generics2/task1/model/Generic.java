package com.walking.lesson29_generics2.task1.model;

public class Generic<T> {
    private final T ob;

    public Generic(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
}
