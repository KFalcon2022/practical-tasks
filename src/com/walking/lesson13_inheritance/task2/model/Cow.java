package com.walking.lesson13_inheritance.task2.model;

public class Cow extends Animal {
    private final static String CLASSNAME = "Cow";

    public Cow() {
        super(CLASSNAME);
    }

    public void moo() {
        sound("moo");
    }
}

