package com.walking.lesson17_enum.task2.model;

public enum Animal {
    CAT("meow"), DOG("woof"), COW("moo");
    final String sound;

    Animal(String sound) {
        this.sound = sound;
    }
    public void sound() {
        System.out.println(sound);
        //System.out.println("Unknown animal!");
    }
}
