package com.walking.lesson13_inheritance.task2.model;

public class Dog extends Animal {
    public final String soundOfThis;

    public Dog(String name, String type) {
        super(name, type);
        this.soundOfThis = "woof";
    }

    public void woof() {
        super.sound(soundOfThis);
    }
}
