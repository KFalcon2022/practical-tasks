package com.walking.lesson18_instanceof_getClass.task1_getClass;

import com.walking.lesson18_instanceof_getClass.task1_getClass.animals.*;

/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя getClass().
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[] {new Cat(), new Cow(), new Unknown(), new Dog(), new Cow()};
        for(Animal animal : animals) {
            animal.getClass();
            animal.sound();
        }
    }
}
