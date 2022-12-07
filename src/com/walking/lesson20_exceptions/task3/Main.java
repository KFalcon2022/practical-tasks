package com.walking.lesson20_exceptions.task3;


import com.walking.lesson20_exceptions.task3.exceptions.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.exceptions.UnknownAnimalException;
import com.walking.lesson20_exceptions.task3.model.*;

public class Main {
    public static void main(String[] args) {
        try {

            Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow()};

            for (int i = 0; i < animals.length; i++) {
                if (animals[i] == null) {
                    throw new ArrayValidationException(i);
                }
            }

            soundAll(animals);

        } catch (ArrayValidationException e) {
            System.out.println("Array element index with empty value : " + e.getNumber());
        }
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            sound(animal);
        }
    }

    private static void sound(Animal animal) {
        try {
            if (animal.getClass().equals(Cat.class)) {
                ((Cat) animal).sound();
            } else if (animal.getClass().equals(Dog.class)) {
                ((Dog) animal).sound();
            } else if (animal.getClass().equals(Cow.class)) {
                ((Cow) animal).sound();
            } else throw new UnknownAnimalException("Unknown animal");

        } catch (UnknownAnimalException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
