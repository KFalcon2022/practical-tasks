package com.walking.lesson16_abstract_class_interface.task2.greet;

public class Unknown implements Greeting {
    @Override
    public String greet() {
        return "Unknown message";
    }
}
