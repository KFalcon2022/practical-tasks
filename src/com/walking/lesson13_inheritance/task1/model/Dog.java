package com.walking.lesson13_inheritance.task1.model;

public class Dog extends Animal {
    private Dog() {
        System.out.println("I’m a dog");
    }

    public Dog(String color) {
        this();

        System.out.printf("I’m a %s dog\n", color);
    }
}
