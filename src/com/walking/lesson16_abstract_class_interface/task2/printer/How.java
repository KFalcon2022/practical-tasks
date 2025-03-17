package com.walking.lesson16_abstract_class_interface.task2.printer;

public class How implements Printer {
    final static String RESPOND = "How are you doing";

    public String print() {
        return RESPOND;
    }

}
