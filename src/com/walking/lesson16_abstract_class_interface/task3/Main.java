package com.walking.lesson16_abstract_class_interface.task3;

/**
 * Реализуйте любую задачу из уроков о наследовании или полиморфизме с использованием новых знаний.
 * Выбирайте инструмент с умом.
 * <p>
 * В качестве задачи выбрана
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
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
                animals[i] = new Cat();
            } else if (i % 3 == 0) {
                animals[i] = new Cow();
            } else {
                animals[i] = new Dog();
            }
        }
    }

    private static void animalSound(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}