package com.walking.lesson18_instanceof_getClass.Task1.zoo;

public class Cow extends Animal{
    public Cow(String name) {
        super(name);
    }
    private final String SOUND="Moo";
    public void Moo(){
        sound(SOUND);
    }
}
