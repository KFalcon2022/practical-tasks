package com.walking.lesson13_inheritance.task2.model;

public class Animal {
    private final String className;
    private final String sound;

    protected Animal(String name, String sound) {
        this.className = name;
        this.sound = sound;
    }

    public String getClassName() {
        return className;
    }

    protected void sound() {
        System.out.println(sound);
    }
}
