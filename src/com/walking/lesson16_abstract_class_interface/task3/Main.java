package com.walking.lesson16_abstract_class_interface.task3;


/**
 * Реализуйте любую задачу из уроков о наследовании или полиморфизме с использованием новых знаний.
 * Выбирайте инструмент с умом.
 * <p>
 * В качестве задачи выбрана
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 */

import com.walking.lesson16_abstract_class_interface.task3.model.*;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];

        animals[0] = new Cat();
        animals[1] = new Dog();
        animals[2] = new Cow();

        outAnimals(animals);
    }

    private static void outAnimals(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }

}

