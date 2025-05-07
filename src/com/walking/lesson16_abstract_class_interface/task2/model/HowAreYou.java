package com.walking.lesson16_abstract_class_interface.task2.model;

public class HowAreYou implements Greeting{
    @Override
    public String printReply() {
        return REPLY_HOW_ARE_YOU;
    }
}
