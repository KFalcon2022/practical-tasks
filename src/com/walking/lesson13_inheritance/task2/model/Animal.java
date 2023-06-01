package com.walking.lesson13_inheritance.task2.model;

public class Animal {
    private final String className;

    public Animal(String className) {

        this.className = className;
    }

    public String getClassName() {

        return className;
    }

    protected void sound(String animalSound) {

        System.out.println(animalSound);
    }
}
