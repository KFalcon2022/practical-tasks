package com.walking.lesson17_enum.task2;

public enum Animal {
    CAT("meow"), COW("moo"), DOG("woof");

    private final String sound;

    public String getSound() {
        return sound;
    }

    Animal(String sound) {
        this.sound = sound;
    }


}
