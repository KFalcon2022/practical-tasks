package com.walking.lesson13_inheritance.task2.model;

public class Cow extends Animal {

    public Cow(String className) {

        super(className);
    }

    public void moo() {
        sound("moo");
    }
}

