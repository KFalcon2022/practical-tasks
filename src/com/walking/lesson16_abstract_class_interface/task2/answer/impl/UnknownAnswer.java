package com.walking.lesson16_abstract_class_interface.task2.answer.impl;

import com.walking.lesson16_abstract_class_interface.task2.answer.Answer;

public class UnknownAnswer implements Answer {
    @Override
    public String getAnswer() {
        return "Unknown message";
    }
}
