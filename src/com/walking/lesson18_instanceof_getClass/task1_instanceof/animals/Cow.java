package com.walking.lesson18_instanceof_getClass.task1_instanceof.animals;

public class Cow extends Animal {
    private final String voice = "moo";

    @Override
    public String getVoice() {
        return voice;
    }

    @Override
    public void sound() {
        System.out.println(getVoice());
    }
}
