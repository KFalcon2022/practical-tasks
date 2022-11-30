package com.walking.lesson17.task2.model;

public class Cat extends Animal{

    public Cat(String name, int age) {
        super(name, age, ANIMALS.CAT);
    }
    
    public void meow(){
        talk("meow");
    }
}