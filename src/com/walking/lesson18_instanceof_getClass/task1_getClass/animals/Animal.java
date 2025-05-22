package com.walking.lesson18_instanceof_getClass.task1_getClass.animals;

public class Animal {
    protected final String sound;

    public Animal(String sound) {
        this.sound = sound;
    }

    protected void sound() {
        System.out.println(sound);
    }
}
