package com.walking.lesson28_generics1.task2;

public class NullChecker <T> {

    T value;

    public NullChecker(T value){
        this.value = value;
    }

    public NullChecker(){};

    public boolean check(){
        return value == null;
    }
}
