package com.walking.lesson13_inheritance.task2.model;

public class Dog extends Animal {

    public Dog(String className) {
        super(className);
    }

    public void woof() {
        sound("woof");
    }
}


