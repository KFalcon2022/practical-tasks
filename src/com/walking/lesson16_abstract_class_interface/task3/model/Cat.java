package com.walking.lesson16_abstract_class_interface.task3.model;

public class Cat extends Animal implements Soundable {
    @Override
    public void makeSound() {
        System.out.println("meow");
    }
}
