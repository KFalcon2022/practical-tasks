package com.walking.lesson45_lyambda.task2;

import com.walking.lesson45_lyambda.task2.model.Animal;
import com.walking.lesson45_lyambda.task2.model.Cat;
import com.walking.lesson45_lyambda.task2.model.Cow;
import com.walking.lesson45_lyambda.task2.model.Dog;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = List.of(new Dog(), new Cat(), new Cow());
        soundAll(animals);
    }

    private static void soundAll(List<Animal> animals) {
        animals.forEach(Animal::sound);
    }
}
