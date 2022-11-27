package com.walking.lesson13_inheritance.task2.model;

public class Animal {
    public final String name;
    public final String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    protected void sound(String mp3) {
        System.out.printf("%s (%s) says %s.\n", this.name, this.type, mp3);
    }
}
