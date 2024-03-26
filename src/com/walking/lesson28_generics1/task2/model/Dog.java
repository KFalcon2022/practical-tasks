package com.walking.lesson28_generics1.task2.model;

public class Dog extends Animal {
    public final static String DOG_SOUND_MESSAGE = "woof";

    @Override
    public String sound() {
        return DOG_SOUND_MESSAGE;
    }
}
