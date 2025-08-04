package com.walking.lesson40_queue2.model;

public class Task {
    private final String name;
    private Task prev;

    public Task(String name) {
        this.name = name;
    }

    public Task(String name, Task prev) {
        this.name = name;
        this.prev = prev;
    }

    public String getName() {
        return name;
    }

    public Task getPrev() {
        return prev;
    }

    public void setPrev(Task prev) {
        this.prev = prev;
    }
}
