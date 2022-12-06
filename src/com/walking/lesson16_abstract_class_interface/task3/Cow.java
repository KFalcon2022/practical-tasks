package com.walking.lesson16_abstract_class_interface.task3;

public class Cow extends Animal {
    public Cow(String species) {
        setName(species);
    }

    public void voice() {
        System.out.println("moo");
    }
}

