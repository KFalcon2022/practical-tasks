package com.walking.lesson16_abstract_class_interface.task2.interfaces;

public class UnknownUswer implements Soundable{
    @Override
    public void sound() {
        System.out.println("Unknown message");
    }
}
