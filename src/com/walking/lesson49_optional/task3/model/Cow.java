package com.walking.lesson49_optional.task3.model;

public class Cow extends Animal{
    private final String ANIMAL_SOUND="Moo";
    @Override
    public String sound() {
        return ANIMAL_SOUND;
    }
}
