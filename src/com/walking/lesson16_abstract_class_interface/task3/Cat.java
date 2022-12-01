package com.walking.lesson16_abstract_class_interface.task3;

public class Cat extends Animal {
    public Cat(String species) {
        setName(species);
    }

    public void voice() {
        System.out.println("meow");
    }
}

