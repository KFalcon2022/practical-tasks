package com.walking.lesson16_abstract_class_interface.task2.model;

public class HiAnswer implements Answer {
    @Override
    public String replay() {
        return HI_REPLAY_MESSAGE;
    }
}
