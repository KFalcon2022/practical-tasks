package com.walking.lesson16_abstract_class_interface.task2.greet;

public class Hello implements Greeting {
    final static String RESPOND = "Hello";

    @Override
    public String greet() {
       return RESPOND;
    }
}
