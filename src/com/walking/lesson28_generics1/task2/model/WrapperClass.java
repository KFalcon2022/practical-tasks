package com.walking.lesson28_generics1.task2.model;

public class WrapperClass <T>{
    private T obj;

    public WrapperClass () {}
    public WrapperClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public boolean isNull() {
        return obj == null;
    }
}
