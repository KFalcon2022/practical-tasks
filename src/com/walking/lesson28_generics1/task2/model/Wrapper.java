package com.walking.lesson28_generics1.task2.model;

public class Wrapper<T> {
    private final T o;

    public Wrapper(T o) {
        this.o = o;
    }

    public T getO() {
        return o;
    }

    public boolean isNull() {
        if (o == null) {
            return true;
        }
        return false;
    }
}
