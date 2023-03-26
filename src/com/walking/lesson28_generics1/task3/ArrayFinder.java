package com.walking.lesson28_generics1.task3;

import java.util.ArrayList;

public class ArrayFinder <T>{

    T[] array;

    public ArrayFinder(T[] array){
        this.array = array;
    }

    public T find(T needle){
        for (T cur:array) {
            if (cur!= null && cur.equals(needle)){
                return cur;
            }
        }
        throw new ArrayStoreException(needle + " not found");
    }
}
