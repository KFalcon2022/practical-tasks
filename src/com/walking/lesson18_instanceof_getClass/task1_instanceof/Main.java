package com.walking.lesson18_instanceof_getClass.task1_instanceof;

import com.walking.lesson13_inheritance.task2.model.Animal;
import com.walking.lesson13_inheritance.task2.model.Cat;
import com.walking.lesson13_inheritance.task2.model.Cow;
import com.walking.lesson13_inheritance.task2.model.Dog;

/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя instanceof.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Cat(), new Dog(), new Cow(), new Dog()};

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            sound(animal);
        }
    }

    private static void sound(Animal animal) {

        if (animal instanceof Cat) {
            ((Cat) animal).meow();
        }
        if (animal instanceof Dog) {
            ((Dog) animal).woof();
        }
        if (animal instanceof Cow) {
            ((Cow) animal).moo();
        }
    }
}
