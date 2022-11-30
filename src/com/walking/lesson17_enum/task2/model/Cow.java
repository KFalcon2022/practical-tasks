package com.walking.lesson17.task2.model;

public class Cow extends Animal{

    public Cow(String name, int age) {
        super(name, age, ANIMALS.COW);
    }
    
    public void moo(){
        talk("moooooooooooooooooooooooo");
    }
}