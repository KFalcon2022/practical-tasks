package com.walking.lesson28_generics1.task2.model;

public class Cat extends Animal {
    public final static String CAT_SOUND_MESSAGE = "meow";

    @Override
    public String sound() {
        return CAT_SOUND_MESSAGE;
    }
}
