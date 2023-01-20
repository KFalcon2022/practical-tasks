package com.walking.lesson16_abstract_class_interface.task3.model;

public class Dog extends Animal implements Guardable {
    public Dog(String color) {
        super(color);
    }

    @Override
    public String whatEat() {
        return "Bones";
    }

    @Override
    public String run() {
        return "Woof woof";
    }
}
