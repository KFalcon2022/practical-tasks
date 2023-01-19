package com.walking.lesson39.Test3;

public class DoubleElement <T> {
    public DoubleElement<T> next;
    public DoubleElement<T> prev;

    public final T data;

    public DoubleElement(T data){
        this.data = data;
        next = null;
        prev = null;
    }

    @Override
    public int hashCode(){
        return data.hashCode();
    }
}
