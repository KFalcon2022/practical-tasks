package com.walking.lesson16_abstract_class_interface.task2.printer;

public class Hello implements Printer {
    final static String RESPOND = "Hello";

    public String print() {
       return RESPOND;
    }
}
