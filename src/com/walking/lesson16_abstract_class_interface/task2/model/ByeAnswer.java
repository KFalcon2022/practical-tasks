package com.walking.lesson16_abstract_class_interface.task2.model;

public class ByeAnswer implements Answer {
    @Override
    public String replay() {
        return BYE_REPLAY_MESSAGE;
    }
}
