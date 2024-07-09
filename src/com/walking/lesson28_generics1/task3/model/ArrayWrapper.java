package com.walking.lesson28_generics1.task3.model;

public class ArrayWrapper<T> {
    private T[] array;

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public ArrayWrapper(T[] array){
        this.array=array;
    }

    public T findValue(T value){
        for(T x:array){
            if (x.equals(value)) return x;
        }
        throw new RuntimeException("Value not found");
    }
}
