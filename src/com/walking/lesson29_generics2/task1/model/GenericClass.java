package com.walking.lesson29_generics2.task1.model;

public class GenericClass <T>{
    private T field;
    public GenericClass(){};
    public GenericClass(T field){
        this.field=field;
    }
    public T getField(){
        return field;
    }
}
