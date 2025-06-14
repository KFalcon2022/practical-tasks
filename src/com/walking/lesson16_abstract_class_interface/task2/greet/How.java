package com.walking.lesson16_abstract_class_interface.task2.greet;

public class How implements Greeting {
    final static String RESPOND = "How are you doing";

    @Override
    public String greet() {
        return RESPOND;
    }

}
