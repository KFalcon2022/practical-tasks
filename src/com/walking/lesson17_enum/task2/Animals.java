package com.walking.lesson17_enum.task2;

public enum Animals {
    CAT("meow"),
    COW("moo"),
    DOG("woof")
    ;
    private String sound;

    Animals(String sound){
        this.sound = sound;
    }

    public void sound(){
        System.out.println(sound);
    }
}
