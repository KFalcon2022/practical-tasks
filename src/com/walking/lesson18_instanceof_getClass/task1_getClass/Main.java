package com.walking.lesson18_instanceof_getClass.task1_getClass;
import com.walking.lesson18_instanceof_getClass.task1_getClass.model.*;
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
        //На случай, если был создан объект Animal, а не наследника.
        if (Cat.class.equals(animal.getClass())) {
            ((Cat) animal).meow();
        } else if (Dog.class.equals(animal.getClass())) {
            ((Dog) animal).woof();
        } else if (Cow.class.equals(animal.getClass())) {
            ((Cow) animal).moo();
        } else {// Или если наследник неизвестен
            System.out.println("Unknown animal");
        }
    }
}