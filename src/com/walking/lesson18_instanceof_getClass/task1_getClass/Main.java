package com.walking.lesson18_instanceof_getClass.task1_getClass;

import com.walking.lesson18_instanceof_getClass.task1_getClass.model.Animal;
import com.walking.lesson18_instanceof_getClass.task1_getClass.model.Cat;
import com.walking.lesson18_instanceof_getClass.task1_getClass.model.Cow;
import com.walking.lesson18_instanceof_getClass.task1_getClass.model.Dog;

/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя getClass().
 * <p>
 * Реализуйте класс Animal. Реализуйте его наследников: Dog, Cat, Cow.
 * Каждый из наследников должен содержать свой метод: woof(), meow() и moo() соответственно.
 * Остальные поля и методы суперкласса и наследников реализовать по своему усмотрению,
 * если они необходимы.
 * <p>
 * Каждый из методов должен выводить в консоль соответствующую ему строку:
 * "woof ", "meow " или "moo".
 * <p>
 * В main() создать и наполнить в произвольном порядке
 * объектами разных классов-наследников массив типа Animal.
 * Реализовать метод, принимающий массив Animal и вызывающий метод,
 * характерный для конкретного животного.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Cat(), new Cow(), new Dog()};
        soundAll(animals);
    }

    private static void soundAll(Animal[] animals){
        for (Animal animal: animals){
            if      (animal.getClass().equals(Cat.class)) ((Cat) animal).meow();
            else if (animal.getClass().equals(Dog.class)) ((Dog) animal).woof();
            else if (animal.getClass().equals(Cow.class)) ((Cow) animal).moo();
            else    System.out.println("Unknown animal");
        }
    }
}
