package com.walking.lesson16_abstract_class_interface.task2.model;

public class HelloMessage implements Message {
    @Override
    public String answer() {
        return "Hello";
    }
}
