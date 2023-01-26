package com.walking.lesson18_instanceof_getClass.task1_getClass;

import com.walking.lesson18_instanceof_getClass.task1_getClass.model.*;

/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя getClass().
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow()};

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            sound(animal);
        }
    }

    //    Используя поле класса Animal, определяем, какой настоящий класс обрабатываемого объекта
    private static void sound(Animal animal) {
        if (animal.getClass().equals(Cat.class)) {
            Cat cat = (Cat) animal;
            cat.meow();
        } else if (animal.getClass().equals(Dog.class)) {
            Dog dog = (Dog) animal;
            dog.woof();
        } else if (animal.getClass().equals(Cow.class)) {
            Cow cow = (Cow) animal;
            cow.moo();
        }
    }
}
