package com.walking.lesson28_generics1.task2;

public class Wrapper<T> {
    private final T wrapper;

    public Wrapper(T wrapper) {
        this.wrapper = wrapper;
    }

    public boolean wrapperNotEmpty() {
        return wrapper != null;
    }

    public T getWrapper() {
        return wrapper;
    }
}
