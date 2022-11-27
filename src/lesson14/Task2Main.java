package com.walking.lesson14_polymorphism.task2;

import com.walking.lesson14_polymorphism.task2.model.Animal;
import com.walking.lesson14_polymorphism.task2.model.Dog;
import com.walking.lesson14_polymorphism.task2.model.Cat;
import com.walking.lesson14_polymorphism.task2.model.Cow;

/**
 * Используя новые знания, упростите реализацию задачи 2 из предыдущего урока.
 * Допустимо использовать метод sound(), вместо woof(), meow() и moo().
 * Метод sound() допустимо сделать публичным.
 *
 * Использовать отдельное поле для хранения выводимой строки — недопустимо:)
 */

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[10];
        animals[0] = new Dog("Бим");
        animals[1] = new Cow("Бурёнка");
        animals[2] = new Cow("Каролина");
        animals[3] = new Cat("Мурзик");
        animals[4] = new Dog("Мухтар");
        animals[5] = new Cat("Шерлок");
        animals[6] = new Cat("Пуша");
        animals[7] = new Dog("Лопоух");
        animals[8] = new Cow("Мумушка");
        animals[9] = new Cat("Рыжик");

        makeSound(animals);
    }

    public static void makeSound(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
