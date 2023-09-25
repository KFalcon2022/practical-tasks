package com.walking.lesson16_abstract_class_interface.task3.animals;

public class Cat extends Animal {
    public static final String CLASS_NAME = "Cat";
    public Cat(String name) {
        super(name,"Meow",CLASS_NAME);
    }

    @Override
    public void getAnimalSound() {
        System.out.println(SOUND);
    }
}
