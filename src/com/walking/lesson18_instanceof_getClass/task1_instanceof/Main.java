package com.walking.lesson18_instanceof_getClass.task1_instanceof;

import com.walking.lesson18_instanceof_getClass.task1_instanceof.model.*;


/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя instanceof.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Cat(), new Dog(), new Cow()};
        soundAll(animals);
    }

    private static void soundAll(Animal[] animals){
        for (Animal animal: animals){
            if      (animal instanceof Cat animalCat) animalCat.meow();
            else if (animal instanceof Dog animalDog) animalDog.woof();
            else if (animal instanceof Cow animalCow) animalCow.moo();
            else    System.out.println("Unknown Animal");
        }
    }
}
