package com.walking.lesson8_classes_objects;

public class Counter {
    public String name;
    public int counter;

    public Counter(String name) {
        this(name, 0);
    }

    public Counter(String name, int counter) {
        this.counter = counter;
        this.name = name;
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
