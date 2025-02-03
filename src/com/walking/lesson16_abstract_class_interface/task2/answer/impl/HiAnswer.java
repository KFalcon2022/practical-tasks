package com.walking.lesson16_abstract_class_interface.task2.answer.impl;

import com.walking.lesson16_abstract_class_interface.task2.answer.Greeting;

public class HiAnswer implements Greeting {

    public HiAnswer() {
        answering();
    }
    @Override
    public void answering() {
        System.out.println("Hello");

    }
}
