package com.walking.lesson16_abstract_class_interface.task2.answer.impl;

import com.walking.lesson16_abstract_class_interface.task2.answer.Greeting;

public class HowAreYouAnswer implements Greeting {

    public HowAreYouAnswer() {
        answering();
    }

    @Override
    public void answering() {
        System.out.println("How are you doing?");
    }
}
