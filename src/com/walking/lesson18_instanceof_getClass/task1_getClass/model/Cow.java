package com.walking.lesson18_instanceof_getClass.task1_getClass.model;

public class Cow extends Animal{
    private static final String SOUND = "moo";

    @Override
    protected void sound() {
        System.out.println(SOUND);
    }
}
