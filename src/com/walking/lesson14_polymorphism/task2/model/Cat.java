package com.walking.lesson14_polymorphism.task2.model;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.printf("%s says meow.\n", this.name);
    }
}
