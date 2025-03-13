package com.walking.lesson16_abstract_class_interface.task3;

public class Cat extends Animal {
    private final String SOUND = "meow";

    public Cat() {
        super();
    }

    public void sound() {
        System.out.println(SOUND);
    }

}
