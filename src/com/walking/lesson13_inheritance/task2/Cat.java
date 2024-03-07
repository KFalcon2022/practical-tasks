package com.walking.inheritance.model;

public class Cat extends Animal {
    public static final String CAT_CLASS_NAME = "Cat";

    public Cat() {
        super(CAT_CLASS_NAME);
    }

    public void sound() {
        System.out.println("meow");
    }
}
