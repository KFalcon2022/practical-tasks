package com.walking.lesson17_enum.task2.model;

public enum Animal {

    CAT("meow"), DOG("woof"), COW("moo");

    private final String voice;

    Animal(String voice) {
        this.voice = voice;
    }

    public void sound() {
        System.out.println(voice);
    }
}
