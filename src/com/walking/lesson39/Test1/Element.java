package com.walking.lesson39.Test1;

public class Element <T> {
    public Element<T> next;

    public final T data;

    public Element(T data){
        this.data = data;
    }

    @Override
    public int hashCode(){
        return data.hashCode();
    }
}
