package com.walking.lesson16_abstract_class_interface.task2.model;

public class HowAreYouMessage implements Message {
    @Override
    public String answer() {
        return "How are your doing";
    }
}
