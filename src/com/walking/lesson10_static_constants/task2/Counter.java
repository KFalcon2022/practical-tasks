package com.walking.lesson10_static_constants.task2;

public class Counter {
    public final String NAME;
    public int counter;

    public Counter(String name) {
        this(name, 0);
    }

    public Counter(String name, int counter) {
        this.counter = counter;
        this.NAME = name;
    }

    public int increase(int value) {
        counter += value;

        return counter;
    }

    public int decrease(int value) {
        counter -= value;

        return counter;
    }

    public int increment() {
        return ++counter;
    }

    public int decrement() {
        return --counter;
    }
}
