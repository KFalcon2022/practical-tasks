package com.walking.lesson16_abstract_class_interface.task3.model;

public class Animal implements SoundAll {

    protected Animal() {}

    public void sound() {
        System.out.println("Unknown animal!");
    }
    public  void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }

}