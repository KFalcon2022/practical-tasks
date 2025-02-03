package com.walking.lesson17_enum.task1;

import java.util.Scanner;

public enum Answer {
    HI("Hello", "Hi"),
    HOW_ARE_YOU("How are you doing?", "How are you"),
    BYE("Good bye", "Bye"),
    UNDEFINED("Undefined message", "");
    final String answer;
    final String question;

    Answer(String answer, String question) {
        this.answer = answer;
        this.question = question;
    }

    public static String getAnswer(Answer[] answers, String message) {
        for (Answer x : answers) {
            if (message.equals(x.question)) {
                return x.answer;
            }
            continue;
        }
        return UNDEFINED.answer;
    }
}
