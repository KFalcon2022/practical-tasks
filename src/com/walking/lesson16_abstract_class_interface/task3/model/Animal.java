package com.walking.lesson16_abstract_class_interface.task3.model;

public abstract class Animal {

    protected final String soundPhrase;

    public Animal(String soundPhrase){
        this.soundPhrase = soundPhrase;
    }

    public abstract void sound();
}
