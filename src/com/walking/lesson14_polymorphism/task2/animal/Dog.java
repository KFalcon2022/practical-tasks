package com.walking.lesson14_polymorphism.task2.animal;

public class Dog extends Animal {
    public Dog() {
        super();
    }

    @Override
    public String sound() {
        return "Woof";
    }
}
