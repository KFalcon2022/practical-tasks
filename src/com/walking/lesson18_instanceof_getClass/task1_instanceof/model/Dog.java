package com.walking.lesson18_instanceof_getClass.task1_instanceof.model;

public class Dog extends Animal {
    private final String sound = "woof";

    @Override
    public void sound() {
        System.out.println(sound);
    }
}
