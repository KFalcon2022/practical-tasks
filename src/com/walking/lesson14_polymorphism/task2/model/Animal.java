package com.walking.lesson14_polymorphism.task2.model;

public class Animal {

    private final String voice;

    Animal(String voice) {
        this.voice = voice;
    }
    public void sound() {
        System.out.println(voice);
    }
}
