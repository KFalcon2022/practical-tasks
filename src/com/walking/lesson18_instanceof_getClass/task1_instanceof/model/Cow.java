package com.walking.lesson18_instanceof_getClass.task1_instanceof.model;

public class Cow extends Animal {
    private final String sound = "moo";

    @Override
    public void sound() {
        System.out.println(sound);
    }
}
