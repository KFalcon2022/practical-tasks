package com.walking.lesson14_polymorphism.task2.model;

public class Cat extends Animal {

    public Cat() {

    }

    @Override
    public void sound() {
        System.out.println("meow");
    }
}
