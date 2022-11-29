package com.walking.lesson14_polymorphism.task2.model;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.printf("%s says woof.\n", this.name);
    }
}
