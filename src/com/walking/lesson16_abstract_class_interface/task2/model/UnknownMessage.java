package com.walking.lesson16_abstract_class_interface.task2.model;

public class UnknownMessage implements Message{
    @Override
    public String message() {
        return "Unknown message";
    }
}
