package com.walking.lesson40_queue2.model;

public class Task {
    private final String name;

    public String getName() {
        return name;
    }

    public Task(String name) {
        this.name = name;
    }

    public void perform() {
        System.out.printf("Task \"%s\" in progress\n", getName());
    }
}
