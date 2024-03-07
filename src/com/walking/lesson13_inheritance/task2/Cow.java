package com.walking.inheritance.model;

public class Cow extends Animal {
    public static final String COW_CLASS_NAME = "Cow";

    public Cow() {
        super(COW_CLASS_NAME);
    }

    public void sound() {
        System.out.println("moo");
    }
}
