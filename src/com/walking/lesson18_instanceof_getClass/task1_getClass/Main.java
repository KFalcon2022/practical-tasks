package com.walking.lesson18_instanceof_getClass.task1_getClass;

import com.walking.lesson18_instanceof_getClass.task1_getClass.model.Animal;
import com.walking.lesson18_instanceof_getClass.task1_getClass.model.Cat;
import com.walking.lesson18_instanceof_getClass.task1_getClass.model.Cow;
import com.walking.lesson18_instanceof_getClass.task1_getClass.model.Dog;

/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя getClass().
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cat(), new Cow()};

        soundAll(animals);
    }
    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            Animal.sound(animal);
        }
    }
}
