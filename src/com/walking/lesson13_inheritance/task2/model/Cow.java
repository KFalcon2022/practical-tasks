package com.walking.lesson13_inheritance.task2.model;

public class Cow extends Animal {
    public final String soundOfThis;

    public Cow(String name, String type) {
        super(name, type);
        this.soundOfThis = "moo";
    }

    public void moo() {
        super.sound(soundOfThis);
    }
}
