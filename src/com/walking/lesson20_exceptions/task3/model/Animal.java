package com.walking.lesson20_exceptions.task3.model;

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
