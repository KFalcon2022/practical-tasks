package com.walking.lesson13_inheritance.task2.model;

public class Cat extends Animal {
    private final static String CLASSNAME = "Cat";

    public Cat() {
        super(CLASSNAME);
    }

    public void meow() {
        sound("meow");
    }
}
