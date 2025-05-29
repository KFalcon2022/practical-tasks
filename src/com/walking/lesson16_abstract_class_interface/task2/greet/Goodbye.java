package com.walking.lesson16_abstract_class_interface.task2.greet;

public class Goodbye implements Greeting {
    final static String RESPOND = "Goodbye";

    @Override
    public String greet() {
        return RESPOND;
    }
}
