package com.walking.lesson16_abstract_class_interface.task2.model;

public class Greetings implements ISender {

    @Override
    public String answer() {
        return "Hello";
    }
    
}
