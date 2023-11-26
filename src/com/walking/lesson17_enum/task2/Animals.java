package com.walking.lesson17_enum.task2;

public enum Animals {
	COW("moo"),
	DOG("woof"),
	CAT("meow");
    private String sound;
    Animals(String sound){
        this.sound = sound;
    }
    public String getSound(){
        return sound;
    }

}