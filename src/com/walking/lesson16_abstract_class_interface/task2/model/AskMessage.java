package com.walking.lesson16_abstract_class_interface.task2.model;

public class AskMessage implements Message{
    @Override
    public String getMessage() {
        return "How are your doing?";
    }
}
