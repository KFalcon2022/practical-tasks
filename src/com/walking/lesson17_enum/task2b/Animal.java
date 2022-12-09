package com.walking.lesson18.task2b;

enum Animal{
    
    CAT("Meow"),
    DOG("Woof"),
    COW("Moo");
    
    private String sound;
    Animal(String sound){
        this.sound = sound;
    }
    
    public String talk(){
        return this.sound;
    }
}