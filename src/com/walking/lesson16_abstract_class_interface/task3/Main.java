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

        Soundable[] animals = new Animal[]{new Cat(), new Cow(), new Dog()};

        for (Soundable animal : animals) {
            animal.makeSound();
        }
    }
}
