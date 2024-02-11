package com.walking.lesson49_optional.task3.model;

import java.util.function.Predicate;

public class Cat extends Animal {
    private final String ANIMAL_SOUND="Meow";

    @Override
    public String sound() {
        return ANIMAL_SOUND;
    }
}
