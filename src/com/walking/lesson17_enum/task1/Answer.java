package com.walking.lesson17_enum.task1;

public enum Answer {
    HI("Hi"),
    BYE("Bye"),
    HOW("How are you doing"),
    UNKNOWN("Unknown message");

    private String answer;

    Answer(String answer) {
        this.answer = answer;
    }

    public void getAnswer() {
        System.out.println(answer);
    }
}
