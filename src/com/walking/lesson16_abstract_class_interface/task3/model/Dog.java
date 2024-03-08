package com.walking.lesson16_abstract_class_interface.task3.model;

public class Dog extends Animal {
    public final static String DOG_SOUND_MESSAGE = "woof";
    public final static String DOG_NAME = "Dog";

    public Dog() {
        super(DOG_NAME);
    }

    @Override
    public String sound() {
        return  DOG_SOUND_MESSAGE;
    }
}
