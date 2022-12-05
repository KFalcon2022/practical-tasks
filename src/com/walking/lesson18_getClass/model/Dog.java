package com.walking.lesson18_getClass.model;

public class Dog extends Animal {
    public static final String DOG_CLASS_NAME = "Dog";

    public Dog() {
        super(DOG_CLASS_NAME, "woof");
    }

    public void woof() {
        sound();
    }
}
