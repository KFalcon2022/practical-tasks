package com.walking.lesson17_enum.task2.model;

public enum Animal {
    CAT("meow"),
    DOG("woof"),
    COW("moo");

    private final String sound;

    Animal(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }
}
