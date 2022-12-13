package com.walking.lesson28_generics.task2;

import com.walking.lesson28_generics.task2.model.ObjectWrapper;

public class Main {
    public static void main(String[] args) {

        ObjectWrapper<Object> objectWrapper = new ObjectWrapper<>("hfghf");

        String empty = null;

        ObjectWrapper<Object> nullReference = new ObjectWrapper<>(empty);

        System.out.println(objectWrapper.isNull());
        System.out.println(nullReference.isNull());
        
    }
}
