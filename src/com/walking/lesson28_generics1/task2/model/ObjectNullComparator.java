package com.walking.lesson28_generics1.task2.model;

public class ObjectNullComparator<T> {

    private final T checkObject;
    public ObjectNullComparator(T checkObject) {
        this.checkObject = checkObject;
    }

    public boolean isNull(){
        return checkObject == null;
    }

}
