package com.walking.lesson16_abstract_class_interface.task2.printer;

public class HowAreYou implements AnswerCreator {
    @Override
    public void getAnswer() {
        System.out.println("How are you doing?");
    }
}