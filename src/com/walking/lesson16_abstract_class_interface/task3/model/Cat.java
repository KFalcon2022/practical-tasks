package com.walking.lesson16_abstract_class_interface.task3.model;

public class Cat extends Animal{
    public Cat(String name)
    {
        super(name);
    }

    @Override
    public String sound() {
        return "Meow";
    }
}
