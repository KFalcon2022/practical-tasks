package com.walking.lesson14_polymorphism.task2.animal;

public class Cow extends Animal {
    public Cow() {
        super();
    }

    @Override
    public String sound() {
        return "Moo";
    }
}
