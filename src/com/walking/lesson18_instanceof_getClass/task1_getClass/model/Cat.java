package com.walking.lesson18_instanceof_getClass.task1_getClass.model;

public class Cat extends Animal{
    private static final String SOUND = "meow";

    @Override
    protected void sound() {
        System.out.println(SOUND);
    }
}
