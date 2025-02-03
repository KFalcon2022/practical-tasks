package com.walking.lesson18_instanceof_getClass.task1_instanceof;

import com.walking.lesson18_instanceof_getClass.task1_instanceof.model.Animal;
import com.walking.lesson18_instanceof_getClass.task1_instanceof.model.Cat;
import com.walking.lesson18_instanceof_getClass.task1_instanceof.model.Cow;
import com.walking.lesson18_instanceof_getClass.task1_instanceof.model.Dog;

/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя instanceof.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat(), new Cow(), new Dog(), new Cow(), new Cat()};

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            sound(animal);
        }
    }

    private static void sound(Animal animal) {
        if (animal instanceof Cat cat) {
            cat.sound();
        } else if (animal instanceof Dog dog) {
            dog.sound();
        } else if (animal instanceof Cow cow) {
            cow.sound();
        } else {
            System.out.println("Undefined animal");
        }
    }
}
