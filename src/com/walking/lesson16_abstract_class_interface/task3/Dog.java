package com.walking.lesson16_abstract_class_interface.task3;

public class Dog extends Animal {
    public Dog(String species) {
        setName(species);
    }

    public void voice() {
        System.out.println("woof");
    }
}

