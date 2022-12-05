package com.walking.lesson16_abstract_class_interface.task3.model;

public class Cat extends Animal {
    public Cat(){
        super.sound="MEOW";
    }
    @Override
    public void sound() {
        System.out.println("meow");
    }
}