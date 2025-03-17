package com.walking.lesson16_abstract_class_interface.task2.printer;

public class Goodbye implements Printer {
    final static String RESPOND = "Goodbye";

    public String print() {
        return RESPOND;
    }
}
