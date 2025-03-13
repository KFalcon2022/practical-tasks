package com.walking.lesson16_abstract_class_interface.task2;

public class How implements Printer {
    final static String MASSAGE = "How are you";
    final static String RESPOND = "How are you doing";

    public static void print() {
        System.out.println(RESPOND);
    }
}
