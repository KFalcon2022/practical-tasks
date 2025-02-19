package com.walking.lesson25_nested_classes.task2.inner_class;

import com.walking.lesson25_nested_classes.task2.inner_class.model.Animal;
import com.walking.lesson25_nested_classes.task2.inner_class.model.AnimalSound;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя внутренние классы.
 */
public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        AnimalSound[] animalSounds = new AnimalSound[]{animal.new Cat(), animal.new Dog(), animal.new Cow()};

        soundAll(animalSounds);
    }

    private static void soundAll(AnimalSound[] animalSounds) {
        for (AnimalSound animalSound : animalSounds) {
            animalSound.sound();
        }
    }
}
