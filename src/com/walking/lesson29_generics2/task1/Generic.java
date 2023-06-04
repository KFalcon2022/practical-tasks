package com.walking.lesson29_generics2.task1;

public class Generic <T>{
    private T value;

    public T getValue() {
        return value;
    }

    public Generic(T value){
        this.value = value;
    }

    public Generic(){}


}
