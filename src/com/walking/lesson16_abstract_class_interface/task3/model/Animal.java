package com.walking.lesson16_abstract_class_interface.task3.model;

public abstract class Animal implements AnimalAction{
    protected String name;
    public Animal(String name)
    {
        this.name = name;
    }
    @Override
    public String sound() {
        return "Животное не определено";
    }
}
