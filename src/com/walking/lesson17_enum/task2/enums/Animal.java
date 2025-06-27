package com.walking.lesson17_enum.task2.enums;

public enum Animal {
    DOG("Woof"),
    CAT("Meow"),
    COW("Moo");

    final String ANIMAL_VOICE;
    Animal(String voice){
        this.ANIMAL_VOICE = voice;
    }

    public String sound(){
        return ANIMAL_VOICE;
    }
}
