package com.walking.lesson18_instanceof_getClass.task1_instanceof.animals;

public class Dog extends Animal {

    public Dog() {
        super("woof");
    }

    public void woof() {
        System.out.println(sound);
    }
}
