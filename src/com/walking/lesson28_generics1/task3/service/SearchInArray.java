package com.walking.lesson28_generics1.task3.service;

import com.walking.lesson28_generics1.task3.exception.Except;

public class SearchInArray <T>{
    private T[] array;

    public SearchInArray(T[] array){
        this.array = array;
    }
    public T search(T key){
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(key)){
                return array[i];
            }
        }
        throw new Except();
    }
}
