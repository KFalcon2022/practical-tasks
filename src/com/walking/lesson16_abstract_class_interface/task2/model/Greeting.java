package com.walking.lesson16_abstract_class_interface.task2.model;

public interface Greeting {
    String REPLY_HI = "Hello";
    String REPLY_BYE = "Good bye";
    String REPLY_HOW_ARE_YOU = "How are you doing";
    String REPLY_UNKNOWN = "Unknown message";

    String printReply();
}
