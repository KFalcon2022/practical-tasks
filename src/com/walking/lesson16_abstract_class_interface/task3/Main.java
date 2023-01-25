package com.walking.lesson16_abstract_class_interface.task3;


import com.walking.lesson16_abstract_class_interface.task3.model.*;

/**
 * Реализуйте любую задачу из уроков о наследовании или полиморфизме с использованием новых знаний.
 * Выбирайте инструмент с умом.
 * <p>
 * В качестве задачи выбрана
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 */
public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Fido");
        Animal cat = new Cat("Tom");
        Guard bot = new Bot();

        feedAnimal(dog);
        feedAnimal(cat);

        guardMe((Dog)dog);
        guardMe(bot);
    }

    private static void guardMe(Guard guard) {
        System.out.println(guard.getClass().getSimpleName() + ": " + guard.run());
    }

    private static void feedAnimal(Animal animal) {
        System.out.println(animal.getClass().getSimpleName() + ": " + animal.getName() + " will eat " + animal.feed());
    }
}
