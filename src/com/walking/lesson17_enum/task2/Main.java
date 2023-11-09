package com.walking.lesson17_enum.task2;

import com.walking.lesson16_abstract_class_interface.task3.model.Cat;
import com.walking.lesson17_enum.task2.model.Animal;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * через enum. Пусть Cow, Dog и Cat будут значениями enum'а Animal.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{Animal.Dog, Animal.Cat, Animal.Cow};
        soundAll(animals);
    }

    public static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            System.out.println(animal.getSound());
        }
    }
}
