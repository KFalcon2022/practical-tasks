package com.walking.lesson18_instanceof_getClass.task1_getClass;

import com.walking.lesson18_instanceof_getClass.Task1.Animal;
import com.walking.lesson18_instanceof_getClass.Task1.Cat;
import com.walking.lesson18_instanceof_getClass.Task1.Cow;
import com.walking.lesson18_instanceof_getClass.Task1.Dog;

/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя getClass().
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow()};
        soundALl(animals);

    }

    public static void soundALl(Animal[] animals) {
        for (Animal animal : animals) {
            if (animal.getClass().equals(Cat.class)) {
                ((Cat) animal).meow();
            } else if (animal.getClass().equals(Dog.class)) {
                ((Dog) animal).woof();
            } else if (animal.getClass().equals(Cow.class)) {
                ((Cow) animal).moo();
            } else System.out.println("Unknown animal");
        }
    }
}
