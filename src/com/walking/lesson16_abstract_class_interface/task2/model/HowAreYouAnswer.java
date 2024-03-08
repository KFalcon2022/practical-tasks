package com.walking.lesson16_abstract_class_interface.task2.model;

public class HowAreYouAnswer implements Answer {
    @Override
    public String replay() {
        return HOW_ARE_YOU_REPLAY_MESSAGE;
    }
}
