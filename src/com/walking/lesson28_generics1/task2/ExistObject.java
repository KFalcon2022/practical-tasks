package com.walking.lesson28_generics1.task2;

public class ExistObject <T>{
    private T object;

    public ExistObject(T object) {
        this.object = object;
    }

    public boolean checkThis (){

        if (object == null) {

            return false;
        }

        return true;
    }
}
