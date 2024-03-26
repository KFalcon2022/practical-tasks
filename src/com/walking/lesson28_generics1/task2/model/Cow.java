package com.walking.lesson28_generics1.task2.model;

public class Cow extends Animal {
    public final static String COW_SOUND_MESSAGE = "moo";

    @Override
    public String sound() {
        return COW_SOUND_MESSAGE;
    }
}
