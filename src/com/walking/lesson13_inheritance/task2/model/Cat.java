package com.walking.lesson13_inheritance.task2.model;

public class Cat extends Animal {

    public Cat(String className) {
        super(className);
    }

    public void meow() {
        sound("meow");
    }
}
