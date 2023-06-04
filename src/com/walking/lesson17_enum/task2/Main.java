package com.walking.lesson17_enum.task2;




/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * через enum. Пусть Cow, Dog и Cat будут значениями enum'а Animal.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("---lesson17_enum.task2---");
        Animals[] animals = {Animals.CAT, Animals.COW, Animals.DOG};

        soundAll(animals);
    }

    private static void soundAll(Animals[] animals) {
        for (Animals animal : animals) {
            animal.sound();
        }
    }
}
