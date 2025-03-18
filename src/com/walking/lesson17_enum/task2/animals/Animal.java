package com.walking.lesson17_enum.task2.animals;

public enum Animal {
    CAT("meow"), Dog("woof"), Cow("moo");

    private final String sound;

    Animal(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }
}
