package com.walking.lesson18_instanceof_getClass.Task1.zoo;

public abstract class Animal {
    private final String NAME;
    protected Animal(String name) {
        NAME = name;
    }
    protected void sound(String sound){
        System.out.println(sound);
    }
}
