package com.walking.lesson29_generics2.task1.model;

public class Generic1 <T extends Object> {
    T value;
    public T getValue() {
        return value;
    }
    public boolean isEmpty() {
        return value == null;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public Generic1(T value) {
        this.value = value;
    }
}
