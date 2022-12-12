package com.walking.lesson28.Task2;

public class Test<T>{
    private T value;

    public Test(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public boolean isEmpty(){
        return value == null;
    }
}
