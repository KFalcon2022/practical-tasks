package com.walking.lesson16_abstract_class_interface.task1_interface;

public class Goodbye implements Printer {
    final static String MASSAGE = "Bye";
    final static String RESPOND = "Goodbye";

    public static void print() {
        System.out.println(RESPOND);
    }
}
