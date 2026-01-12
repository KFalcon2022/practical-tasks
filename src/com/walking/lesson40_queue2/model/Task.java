package com.walking.lesson40_queue2.model;

public class Task {
    private final String name;
    private final int answer;

    public Task(String name, int answer) {
        this.name = name;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public int getAnswer() {
        return answer;
    }
}
