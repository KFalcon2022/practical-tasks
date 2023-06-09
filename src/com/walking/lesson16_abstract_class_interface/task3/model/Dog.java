package com.walking.lesson16_abstract_class_interface.task3.model;

public class Dog extends Animal{
    public Dog(String name)
    {
        super(name);
    }

    @Override
    public String sound() {
        return "Woof";
    }
}
