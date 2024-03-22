package com.walking.lesson18_instanceof_getClass.task1_getClass;


import com.walking.lesson18_instanceof_getClass.model.Animal;
import com.walking.lesson18_instanceof_getClass.model.Cat;
import com.walking.lesson18_instanceof_getClass.model.Cow;
import com.walking.lesson18_instanceof_getClass.model.Dog;

/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя getClass().
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
            if (animal.getClass().equals(Cat.class)) {
                Cat cat = (Cat) animal;
                cat.meow(animal);
            } else if (animal.getClass().equals(Dog.class)) {
                Dog dog = (Dog) animal;
                dog.woof(animal);
            } else if (animal.getClass().equals(Cow.class)) {
                Cow cow = (Cow) animal;
                cow.moo(animal);
            }
        }
    }
}
