package com.walking.lesson16_abstract_class_interface.task3;


import com.walking.lesson16_abstract_class_interface.task3.animals.*;

/**
 * Реализуйте любую задачу из уроков о наследовании или полиморфизме с использованием новых знаний.
 * Выбирайте инструмент с умом.
 * <p>
 * В качестве задачи выбрана
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 */
public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik");
        //cat1.meow();

        Dog dog1 = new Dog("Sharik");
        //dog1.woof();

        Cow cow1 = new Cow("Burenka");
        Dog dog2=new Dog("Amur");

        Animal[] animalsArray = new Animal[]{cat1,dog1,cow1,dog2};
        soundAll(animalsArray);
    }

    private static void soundAll(Animal[] animals){
        for (Animal animal:animals){
            animal.getAnimalSound();
        }
    }
}
