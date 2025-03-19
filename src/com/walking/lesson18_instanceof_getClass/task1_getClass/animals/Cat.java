package com.walking.lesson18_instanceof_getClass.task1_getClass.animals;

public class Cat extends Animal{
    private final String voice = "meow";

    @Override
    public String getVoice() {
        return voice;
    }

    @Override
    public void sound() {
        System.out.println(getVoice());
    }
}
