package com.walking.lesson29_generics2.task1;

public class SimpleClass <T>{
    private final T field;


    public SimpleClass(T field) {
        this.field = field;
    }

    public T getField() {
        return field;
    }
}
