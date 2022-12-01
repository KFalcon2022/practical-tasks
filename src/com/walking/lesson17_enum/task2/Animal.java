package com.walking.lesson17_enum.task2;

public enum Animal {
    CAT("meow"),
    COW("moo"),
    DOG("woof");
    private String sound;

    Animal(String sound) {
        this.sound = sound;
    }

    public void sound() {
        System.out.println(sound);
    }
}
