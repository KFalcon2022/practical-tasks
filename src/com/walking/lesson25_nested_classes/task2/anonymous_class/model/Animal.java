package com.walking.lesson25_nested_classes.task2.anonymous_class.model;

public class Animal {
    private final Voiceable voiceable;

    public Animal(Voiceable voiceable) {
        this.voiceable = voiceable;
    }

    public Voiceable getVoiceable() {
        return voiceable;
    }
}
