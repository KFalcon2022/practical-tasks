package com.walking.lesson28_generics1.task2.model;

public class Wrapper<T> {
    private T field;
    public Wrapper(T field){
        this.field=field;
    }
    public boolean isNull(){
        return field==null;
    }

    public T getField(){
        return field;
    }

    public void setField(T field){
        this.field=field;
    }
}
