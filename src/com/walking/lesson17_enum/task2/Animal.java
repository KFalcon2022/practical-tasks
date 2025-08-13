package com.walking.lesson17_enum.task2;

public enum Animal {
    COW("moo"), DOG("woof"), CAT("meow");
    private final String sound;

    Animal(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }
/*
    public static Animal getList() {
        for (Animal animal : Animal.values()) {
            return animal;
        }
        return null;
    }

 */
}
