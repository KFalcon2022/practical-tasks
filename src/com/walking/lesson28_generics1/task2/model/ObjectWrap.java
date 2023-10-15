package com.walking.lesson28_generics1.task2.model;

public class ObjectWrap <T>{
    private T object;
    public ObjectWrap(T object){
        if (!isObjectNull(object)){
            this.object=object;
            System.out.println("You entered "+object+" value.");
        }
        else System.out.println("You entered null value!");
    }

    public T getObject() {
        return object;
    }

    private boolean isObjectNull(T object){
        if (object==null){
            return true;
        }
        return false;
    }
}
