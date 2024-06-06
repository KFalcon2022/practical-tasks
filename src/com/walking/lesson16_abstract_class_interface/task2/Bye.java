package com.walking.lesson16_abstract_class_interface.task2;

public class Bye implements Answer{
    public static final String CALL = "Good bye";

    public void callAnswer() {
        System.out.println(CALL);
    }
}
