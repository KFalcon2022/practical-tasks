package com.walking.lesson16_abstract_class_interface.task3.model;

public abstract class Animal implements Voiceable {
    protected final String name;

    protected Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void identifyAnimal() {
        System.out.print("Hello, i'm a " + name + ".");
    }
}
