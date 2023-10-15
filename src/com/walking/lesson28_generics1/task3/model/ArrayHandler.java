package com.walking.lesson28_generics1.task3.model;

public class ArrayHandler <T>{
    private T[] array;
    public ArrayHandler(T[] array){
        this.array=array;
    }
    public T findValue(T desiredValue) throws Exception {
        for (T value:array){
            if (desiredValue.equals(value)){
                return value;
            }
        }
        throw new Exception("Search is failed. There is no value");
    }
}
