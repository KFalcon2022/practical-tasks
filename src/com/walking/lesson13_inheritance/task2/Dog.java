package com.walking.inheritance.model;

public class Dog extends Animal {
    public static final String DOG_CLASS_NAME = "Dog";

    public Dog() {
        super(DOG_CLASS_NAME);
    }

    public void sound() {
        System.out.println("woof");
    }
}
