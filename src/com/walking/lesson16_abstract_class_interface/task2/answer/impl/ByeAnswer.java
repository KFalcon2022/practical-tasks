package com.walking.lesson16_abstract_class_interface.task2.answer.impl;

import com.walking.lesson16_abstract_class_interface.task2.answer.Greeting;

public class ByeAnswer implements Greeting {

    public ByeAnswer() {

    }

    @Override
    public void answering() {
        System.out.println("Good Bye");
    }
}
