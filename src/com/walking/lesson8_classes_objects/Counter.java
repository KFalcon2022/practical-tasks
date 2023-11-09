package com.walking.lesson8_classes_objects;

public class Counter {
    public String name;
    public int count;

    Counter(String name) {
        this(name, 0);
    }

    Counter(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public void increace() {
        this.count++;
    }

    public void increace(int number) {
        count += number;
    }

    public void decrement() {
        this.count--;
    }

    public void info() {
        System.out.printf("%s: %d", name, count);
        System.out.println();
    }
}
