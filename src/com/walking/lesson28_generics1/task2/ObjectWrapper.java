package com.walking.lesson28_generics1.task2;

public class ObjectWrapper<T> {
    private T object;

    public ObjectWrapper(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public boolean checkNull(ObjectWrapper<T> objectWrapper) {
        return objectWrapper.getObject() == null;
    }
}
