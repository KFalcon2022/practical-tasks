package com.walking.lesson16_abstract_class_interface.task3;


import com.walking.lesson16_abstract_class_interface.task3.animals.Animal;
import com.walking.lesson16_abstract_class_interface.task3.animals.Cat;
import com.walking.lesson16_abstract_class_interface.task3.animals.Cow;
import com.walking.lesson16_abstract_class_interface.task3.animals.Dog;

/**
 * Реализуйте любую задачу из уроков о наследовании или полиморфизме с использованием новых знаний.
 * Выбирайте инструмент с умом.
 * <p>
 * В качестве задачи выбрана
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[] {new Cow(), new Dog(), new Cat()};

        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
