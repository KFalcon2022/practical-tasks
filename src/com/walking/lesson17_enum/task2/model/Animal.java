package com.walking.lesson17_enum.task2.model;

public enum Animal {
    Cat("Meow"),
    Dog("Woof"),
    Cow("Mooo");

    private final String sound;

    Animal(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }
}
