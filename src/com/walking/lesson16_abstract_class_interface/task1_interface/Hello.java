package com.walking.lesson16_abstract_class_interface.task1_interface;

public class Hello implements Printer {
    final static String MASSAGE = "Hi";
    final static String RESPOND = "Hello";

    public static void print() {
        System.out.println(RESPOND);
    }
}
