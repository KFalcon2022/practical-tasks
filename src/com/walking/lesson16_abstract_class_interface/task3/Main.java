package com.walking.lesson16_abstract_class_interface.task3;


public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Dog(), new Cow(), new Cat()};

        soundAll(animals);
        
    }
    public static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
