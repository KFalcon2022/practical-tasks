package com.walking.lesson16_abstract_class_interface.task3.model;

public class Dog implements ISpeaker {
    @Override
    public String sound(){
        return "Woof";
    }
}
