package com.walking.lesson17_enum.task2;

public enum Animal {
    Cow("Moo"),
    Dog("Woof"),
    Cat("Meow");

    private String sound;

    private Animal(String sound){
        this.sound=sound;
    }

    public String getSound(){
        return sound;
    }
}
