package com.walking.lesson20_exceptions.task3;

 class Animal {
    private final String sound;

    protected Animal(String sound) {
        this.sound = sound;
    }

    protected void sound(){
        System.out.println(sound);
    }
}
