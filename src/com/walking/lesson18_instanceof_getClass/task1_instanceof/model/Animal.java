package com.walking.lesson18_instanceof_getClass.task1_instanceof.model;

public class Animal {
    private final String className;
    private final String voice;

    Animal(String className, String voice) {
        this.className = className;
        this.voice = voice;
    }

    public String getClasName() {
        return className;
    }

    protected void sound() {
        System.out.println(voice);
    }
}
