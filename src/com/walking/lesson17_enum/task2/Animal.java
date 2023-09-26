package com.walking.lesson17_enum.task2;

public enum Animal {
    CAT("Meow"),
    DOG("Woof"),
    COW("Moo");
    private final String sound;
    Animal (String sound){
        this.sound=sound;
    }
    public String getSound (){
        return this.sound;
    }
    public void playSound(){
        System.out.println("Some animal says "+sound);
    }
}
