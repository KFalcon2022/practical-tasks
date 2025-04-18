package com.walking.lesson13_inheritance.task1.animal;

public class Cat extends Animal {
    private Cat() {
        System.out.println("I'm a cat");
    }

    public Cat(String color) {
        this();
        System.out.println("I'm a " + color + " cat");
    }
}
