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
        Dog dog = new Dog("Fido");
        Cat cat = new Cat("Tom");
        Guardable bot = new Bot();

        feedAnimal(dog);
        feedAnimal(cat);

        guardMe(dog);
        guardMe(bot);
    }

    private static void guardMe(Guardable guardable) {
        System.out.println(guardable.getClass().getSimpleName() + ": " + guardable.run());
    }

    private static void feedAnimal(Animal animal) {
        System.out.println(animal.getClass().getSimpleName() + ": " + animal.getName() + " will eat " + animal.whatEat());
    }
}
