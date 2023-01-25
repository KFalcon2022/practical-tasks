package com.walking.lesson16_abstract_class_interface.task3.model;

public class Cat extends Animal{
    public Cat(String color) {
        super(color);
    }

    @Override
    public String feed() {
        return "Milk";
    }
}
