package com.walking.lesson25_nested_classes.task2.static_class;

import com.walking.lesson25_nested_classes.task2.static_class.model.Animal;
import com.walking.lesson25_nested_classes.task2.static_class.model.AnimalSound;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя статические вложенные классы.
 */
public class Main {
    public static void main(String[] args) {
        AnimalSound[] animalSounds = new AnimalSound[]{new Animal.Cat(), new Animal.Dog(), new Animal.Cow()};

        soundAll(animalSounds);
    }

    public static void soundAll(AnimalSound[] animalSounds) {
        for (AnimalSound animalSound : animalSounds) {
            animalSound.sound();
        }
    }
}
