package com.walking.lesson18_instanceof_getClass.task1_instanceof.animals;

public class Dog extends Animal {
    private final String voice = "woof";

    @Override
    public String getVoice() {
        return voice;
    }

    @Override
    public void sound() {
        System.out.println(getVoice());
    }
}
