package com.walking.lesson17_enum.task2;

import com.walking.lesson17_enum.task2.model.Animal;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{Animal.DOG, Animal.CAT, Animal.COW};
        soundAll(animals);
    }

    private static void soundAll(Animal... animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}