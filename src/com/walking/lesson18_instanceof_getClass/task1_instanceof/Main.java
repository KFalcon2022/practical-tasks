package com.walking.lesson18_instanceof_getClass.task1_instanceof;

import com.walking.lesson18_instanceof_getClass.task1_instanceof.model.*;


public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow()};

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            sound(animal);
        }
    }

    //    Используя поле класса Animal, определяем, какой настоящий класс обрабатываемого объекта
    private static void sound(Animal animal) {

        if (animal instanceof Cat cat) {
            cat.meow();
        } else if (animal instanceof Dog dog) {
            dog.woof();
        } else if (animal instanceof Cow cow) {
            cow.moo();
        } else {// Или если наследник неизвестен
            System.out.println("Unknown animal");
        }
    }
}