package com.walking.lesson16_abstract_class_interface.task2;

public class Question implements Answer{
    public static final String CALL = "How are you doing?";

    public void callAnswer() {
        System.out.println(CALL);
    }
}
