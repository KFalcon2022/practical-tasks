package com.walking.lesson16_abstract_class_interface.task3.model;

public class Cat extends Animal {
    public final static String CAT_SOUND_MESSAGE = "meow";
    public final static String CAT_NAME = "Cat";

    public Cat() {
        super(CAT_NAME);
    }

    @Override
    public String sound() {
        return CAT_SOUND_MESSAGE;
    }
}
