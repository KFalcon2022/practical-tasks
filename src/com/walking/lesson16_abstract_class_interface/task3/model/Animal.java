package com.walking.lesson16_abstract_class_interface.task3.model;

public abstract class Animal {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void sound();

}
