package com.walking.lesson14_polymorphism.task2.animal;

public class Cat extends Animal {
    public Cat() {
        super();
    }

    @Override
    public String sound() {
        return "Meow";
    }
}
