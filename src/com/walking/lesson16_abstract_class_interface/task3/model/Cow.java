package com.walking.lesson16_abstract_class_interface.task3.model;

public class Cow extends Animal {
    public final static String COW_SOUND_MESSAGE = "moo";
    public final static String COW_NAME = "Cat";

    public Cow() {
        super(COW_NAME);
    }

    @Override
    public String sound() {
        return COW_SOUND_MESSAGE;
    }
}
