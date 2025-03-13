package com.walking.lesson16_abstract_class_interface.task3;

public class Cow extends Animal {
    private final String SOUND = "moo";

    public Cow() {
        super();
    }

    public void sound() {
        System.out.println(SOUND);
    }

}
