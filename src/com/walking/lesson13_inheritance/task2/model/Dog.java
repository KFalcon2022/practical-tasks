package com.walking.lesson13_inheritance.task2.model;

public class Dog extends Animal {
    private final static String CLASSNAME = "Dog";

    public Dog() {
        super(CLASSNAME);
    }

    public void woof() {
        sound("woof");
    }
}


