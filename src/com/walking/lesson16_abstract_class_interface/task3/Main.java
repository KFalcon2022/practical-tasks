package com.walking.lesson16_abstract_class_interface.task3;

import com.walking.lesson16_abstract_class_interface.task3.*;
import com.walking.lesson16_abstract_class_interface.task3.model.Animal;
import com.walking.lesson16_abstract_class_interface.task3.model.Cat;
import com.walking.lesson16_abstract_class_interface.task3.model.Cow;
import com.walking.lesson16_abstract_class_interface.task3.model.Dog;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * Реализуйте любую задачу из уроков о наследовании или полиморфизме с использованием новых знаний.
 * Выбирайте инструмент с умом.
 * <p>
 * В качестве задачи выбрана
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 */
public class Main {
    public static void main(String[] args) {

        Animal[] animalSound = new Animal[3];
        animalSound[0] = new Cat();
        animalSound[1] = new Dog();
        animalSound[2] = new Cow();

        for (int i = 0; i < animalSound.length; i++){
            System.out.println(animalSound[i].sound());
        }

    }
}
