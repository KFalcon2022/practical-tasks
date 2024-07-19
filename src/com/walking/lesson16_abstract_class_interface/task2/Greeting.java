package com.walking.lesson16_abstract_class_interface.task2;

public class Greeting implements Answer{
    public static final String CALL = "Hello";

    public void callAnswer() {
        System.out.println(CALL);
    }
}
