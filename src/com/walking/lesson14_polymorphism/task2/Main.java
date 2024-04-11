package com.walking.lesson14_polymorphism.task2;


import com.walking.lesson14_polymorphism.task2.model.Animal;
import com.walking.lesson14_polymorphism.task2.model.Cat;
import com.walking.lesson14_polymorphism.task2.model.Cow;
import com.walking.lesson14_polymorphism.task2.model.Dog;

/**
 * Используя новые знания, упростите реализацию задачи 2 из предыдущего урока.
 * Допустимо использовать метод sound(), вместо woof(), meow() и moo().
 * Метод sound() допустимо сделать публичным.
 * Использовать отдельное поле для хранения выводимой строки — недопустимо:)
 */
public class Main {

    public static void main(String[] args) {
        Animal[] animals = new Animal[10];
        fillAnimalsArray(animals);
        animalSound(animals);
    }

    private static void fillAnimalsArray(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            if (i % 2 == 0) {
                animals[i] = new Cat();
            } else if (i % 3 == 0) {
                animals[i] = new Cow();
            } else {
                animals[i] = new Dog();
            }
        }
    }

    private static void animalSound(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}


