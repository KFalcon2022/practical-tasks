package com.walking.lesson18_instanceof_getClass.task1_instanceof;


import com.walking.lesson18_instanceof_getClass.task1_instanceof.animals.*;

/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя instanceof.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat(), new Cow(), new Dog(), new Cow()};
        for (Animal animal : animals) {
            if (animal instanceof Cat cat) {
                cat.meow();
            } else if (animal instanceof Dog dog) {
                dog.woof();
            } else if (animal instanceof Cow cow) {
                cow.moo();
            } else {
                System.out.println("Unknown animal");
            }
        }
    }
}
