package com.walking.lesson18_instanceof_getClass.Task1.zoo;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }
    private final String SOUND="Woof";
    public void woof(){
        sound(SOUND);
    }
}
