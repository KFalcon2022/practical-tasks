package com.walking.lesson16_abstract_class_interface.task3.model;

public class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }

    public void sound() {
        System.out.println("moo");
    }

}
