package com.walking.lesson16_abstract_class_interface.task3;


import com.walking.lesson16_abstract_class_interface.task3.model.Animal;
import com.walking.lesson16_abstract_class_interface.task3.model.inherit.Cat;
import com.walking.lesson16_abstract_class_interface.task3.model.inherit.Cow;
import com.walking.lesson16_abstract_class_interface.task3.model.inherit.Dog;

/**
 * Реализуйте любую задачу из уроков о наследовании или полиморфизме с использованием новых знаний.
 * Выбирайте инструмент с умом.
 * <p>
 * В качестве задачи выбрана
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 */
public class Main {
    public static void main(String[] args) {
        Animal[] zoo = new Animal[]{new Cat(), new Dog(), new Cow()};

        for (Animal animal : zoo) {
            System.out.println(animal.Sound());
        }

    }
}
