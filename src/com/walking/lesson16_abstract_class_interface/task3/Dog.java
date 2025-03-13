package com.walking.lesson16_abstract_class_interface.task3;

public class Dog extends Animal {
    private final String SOUND = "woof";

    public Dog() {
        super();
    }

    public void sound() {
        System.out.println(SOUND);
    }

}
