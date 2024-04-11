package com.walking.lesson10_static_constants.task2;

public class Counter {
    final String name;
    int count;

    public Counter(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public Counter(String name) {
        this(name, 0);
    }

    public int incrementCounter() {
        return count++;
    }

    public int decrementCounter() {
        return count--;
    }

    public int increaseCounter(int quantity) {
        count += quantity;
        return count;
    }

    public int decreaseCounter(int quantity) {
        count -= quantity;
        return count;
    }
}
