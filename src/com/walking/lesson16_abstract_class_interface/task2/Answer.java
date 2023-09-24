package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task2.interfaces.*;

public class Answer implements Printable, HiAnswer, ByeAnswer, HowAreYouAnswer, UnknownAnswer {
    @Override
    public void hiAnswer() {
         printMessage("Hello");
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void byeAnswer() {
        printMessage("Good Bye");
    }

    @Override
    public void howAreYouAnswer() {
        printMessage("How are you doing");
    }

    @Override
    public void unknownAnswer() {
        printMessage("Unknown message");
    }
}
