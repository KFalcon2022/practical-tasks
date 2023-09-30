package com.walking.lesson18_instanceof_getClass.Task1.zoo;

public class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }
    private final String SOUND="Meow";
    public void meow(){
        sound(SOUND);
    }
}
