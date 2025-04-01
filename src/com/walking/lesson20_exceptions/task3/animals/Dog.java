package com.walking.lesson20_exceptions.task3.animals;

public class Dog extends Animal {

    public Dog() {
        super("woof");
    }

    public void woof() {
        System.out.println(sound);
    }
}
