package com.walking.lesson18_instanceof_getClass.Task1;

import com.walking.lesson18_instanceof_getClass.Task1.model.Animal;
import com.walking.lesson18_instanceof_getClass.Task1.model.Cat;
import com.walking.lesson18_instanceof_getClass.Task1.model.Cow;
import com.walking.lesson18_instanceof_getClass.Task1.model.Dog;

public class Main {
    public static void main(String[] args) {
        System.out.println("---lesson18_instanceof_getClass---");
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow()};

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            sound(animal, 0);
            sound(animal, 2);
        }
    }

    //    Используя поле класса Animal, определяем, какой настоящий класс обрабатываемого объекта
    private static void sound(Animal animal, int method) {
        //На случай, если был создан объект Animal, а не наследника.
        if (method == 0) {
            if (Cat.class.equals(animal.getClass())) {
                ((Cat) animal).meow();
            } else if (Dog.class.equals(animal.getClass())) {
                ((Dog) animal).woof();
            } else if (Cow.class.equals(animal.getClass())) {
                ((Cow) animal).moo();
            } else {// Или если наследник неизвестен
                System.out.println("Unknown animal!");
            }
        } else {
            if (animal instanceof Cat){
                ((Cat) animal).meow();
            } else if (animal instanceof Dog) {
                ((Dog) animal).woof();
            } else if (animal instanceof Cow) {
                ((Cow) animal).moo();
            } else {// Или если наследник неизвестен
                System.out.println("Unknown animal!");
            }
        }
    }

}
