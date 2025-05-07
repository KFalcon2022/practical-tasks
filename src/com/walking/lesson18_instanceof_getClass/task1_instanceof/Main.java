package com.walking.lesson18_instanceof_getClass.task1_instanceof;

import com.walking.lesson13_inheritance.task2.model.Animal;
import com.walking.lesson13_inheritance.task2.model.Cat;
import com.walking.lesson13_inheritance.task2.model.Cow;
import com.walking.lesson13_inheritance.task2.model.Dog;

/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя instanceof.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow()};

        getSound(animals);
    }

    public static void getSound(Animal[] animals) {
        for (Animal member : animals) {
            if (member instanceof Cat) {
                ((Cat) member).meow();
            } else if (member instanceof Dog) {
                ((Dog) member).woof();
            } else if (member instanceof Cow) {
                ((Cow) member).moo();
            } else {
                System.out.println("Unknown animal");
            }
        }
    }
}

