package com.walking.lesson17_enum.task2;

import com.walking.lesson17_enum.task2.animal.AnimalType;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * через enum. Пусть Cow, Dog и Cat будут значениями enum'а Animal.
 */
public class Main {
    public static void main(String[] args) {
        AnimalType[] animals = new AnimalType[]{AnimalType.DOG, AnimalType.CAT, AnimalType.COW, AnimalType.DOG};

        soundAll(animals);
    }

    private static void soundAll(AnimalType[] animals) {
        for (AnimalType animal : animals) {
            animal.sound();
        }
    }
}
