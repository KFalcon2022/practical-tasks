package com.walking.lesson18_instanceof_getClass.task1_getClass.animals;

public class Unknown extends Animal{

    @Override
    public String getVoice() {
        return "Unknown animal";
    }

    @Override
    public void sound() {
        System.out.println(getVoice());
    }
}
