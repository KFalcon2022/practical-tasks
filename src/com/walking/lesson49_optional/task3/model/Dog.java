package com.walking.lesson49_optional.task3.model;

public class Dog extends Animal{
    private final String ANIMAL_SOUND="Woof";

    @Override
    public String sound() {
        return ANIMAL_SOUND;
    }
}
