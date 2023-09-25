package com.walking.lesson16_abstract_class_interface.task3.animals;

public class Cow extends Animal {
    public static final String CLASS_NAME = "Cow";
    public Cow(String name) {
        super(name,"Mooo",CLASS_NAME);
    }

    @Override
    public void getAnimalSound() {
        System.out.println(SOUND);
    }
}
