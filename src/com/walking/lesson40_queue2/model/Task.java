package com.walking.lesson40_queue2.model;

public class Task {
    private final String name;
    private final String question;
    private final int answer;

    public Task(String name, String question, int answer) {
        this.name = name;
        this.question = question;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public String getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }
}
