package com.walking.lesson17.task2.model;

public class Dog extends Animal{

    public Dog(String name, int age) {
        super(name, age, ANIMALS.DOG);
    }
    
    public void woof(){
        talk("bow-wow");
    }
}