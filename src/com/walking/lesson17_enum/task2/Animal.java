package com.walking.lesson17_enum.task2;

enum Animal {
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

    public void playSound() {
        System.out.println(sound);
    }
}
