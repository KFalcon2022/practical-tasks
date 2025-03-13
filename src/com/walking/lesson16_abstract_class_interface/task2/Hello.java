package com.walking.lesson16_abstract_class_interface.task2;

public class Hello implements Printer {
    final static String MASSAGE = "Hi";
    final static String RESPOND = "Hello";

    public static void print() {
        System.out.println(RESPOND);
    }
}
