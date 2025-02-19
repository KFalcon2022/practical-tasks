package com.walking.lesson41_set.task1;

public class Task implements Comparable<Task> {
    private final String name;
    private final long orderValue;

    private static long counter = 0;

    public Task(String name) {
        this.name = name;
        this.orderValue = counter++;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Task o) {
        return Long.compare(this.orderValue, o.orderValue);
    }
}
