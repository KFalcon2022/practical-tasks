package com.walking.lesson29_wildcard.task1.model;

public class SomeGeneric<E> {

    private final E field;

    public SomeGeneric() {
        this(null);
    }

    public SomeGeneric(E element) {
        this.field = element;
    }

    public E getField() {
        return field;
    }
}
