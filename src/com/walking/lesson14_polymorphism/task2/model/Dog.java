package com.walking.lesson14_polymorphism.task2.model;

public class Dog extends Animal {

    public Dog() {

    }

    @Override
    public void sound() {
        System.out.println("woof");
    }
}
