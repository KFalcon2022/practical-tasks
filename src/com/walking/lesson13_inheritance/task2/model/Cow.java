package com.walking.lesson13_inheritance.task2.model;

public class Cow extends Animal {
    public static final String COW_CLASS_NAME = "Cow";

    public Cow() {
        super(COW_CLASS_NAME, "moo");
    }

    public void moo() {
        sound();
    }
}
