package com.walking.lesson18_instanceof_getClass.task1_getClass.model;

public class Dog extends Animal{
    private static final String SOUND = "woof";

    @Override
    protected void sound() {
        System.out.println(SOUND);
    }
}
