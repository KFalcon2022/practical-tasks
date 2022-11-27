package com.walking.lesson14_polymorphism.task2.model;

public class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.printf("%s says moo.\n", this.name);
    }
}
