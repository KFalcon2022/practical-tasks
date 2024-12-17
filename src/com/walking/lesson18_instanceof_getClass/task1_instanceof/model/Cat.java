package com.walking.lesson18_instanceof_getClass.task1_instanceof.model;

public class Cat extends Animal {
    private final String sound = "meow";

    @Override
    public void sound() {
        System.out.println(sound);
    }
}
