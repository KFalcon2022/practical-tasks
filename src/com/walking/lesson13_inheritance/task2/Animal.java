package com.walking.inheritance.model;

public class Animal {
    private final String className;

    protected Animal(String name) {
        this.className = name;
    }

    public String getClassName() {
        return className;
    }

    public void sound() {
        System.out.println("Что за зверь?");
    }
}
