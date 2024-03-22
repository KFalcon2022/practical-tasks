package com.walking.lesson17_enum.task2;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * через enum. Пусть Cow, Dog и Cat будут значениями enum'а Animal.
 */


import com.walking.lesson17_enum.task2.model.Animal;

/**
 * Используя новые знания, упростите реализацию задачи 2 из предыдущего урока.
 * Допустимо использовать метод sound(), вместо woof(), meow() и moo().
 * Метод sound() допустимо сделать публичным.
 * Использовать отдельное поле для хранения выводимой строки — недопустимо:)
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[10];
        fillAnimalsArray(animals);
        animalSound(animals);
    }

    private static void fillAnimalsArray(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            if (i % 2 == 0) {
                animals[i] = Animal.CAT;
            } else if (i % 3 == 0) {
                animals[i] = Animal.DOG;
            } else {
                animals[i] = Animal.COW;
            }
        }
    }

    private static void animalSound(Animal[] animals) {
        for (Animal animal : animals) {
            System.out.println(animal.getSound());
        }
    }
}
