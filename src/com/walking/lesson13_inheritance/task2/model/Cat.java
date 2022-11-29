package com.walking.lesson13_inheritance.task2.model;

public class Cat extends Animal {
    public final String soundOfThis;

    public Cat(String name, String type) {
        super(name, type);
        this.soundOfThis = "meow";
    }

    public void meow() {
        super.sound(soundOfThis);
    }
}
