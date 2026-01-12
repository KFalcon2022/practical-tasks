package com.walking.lesson41_set.task1.model;

public class Task {
    private final String name;
    private final int answer;
    private int number;

    public Task(String name, int answer) {
        this.name = name;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int getAnswer() {
        return answer;
    }
}
