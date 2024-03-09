package com.walking.lesson13_inheritance.task2;

import com.walking.lesson13_inheritance.task2.model.Animal;
import com.walking.lesson13_inheritance.task2.model.Cat;
import com.walking.lesson13_inheritance.task2.model.Cow;
import com.walking.lesson13_inheritance.task2.model.Dog;

/**
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
 * <p>
 * Использовать при решении instanceof, getClass() или другие неизвестные нам механики – недопустимо.
 * <p>
 * Дополнительное условие (необязательно): решить задачу, при условии,
 * что woof(), meow() и moo() внутри себя выполняют только вызов protected-метода sound(),
 * который определен в Animal.
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
            switch (animal.getClassName()) {
                case "Cat" -> {
                    Cat cat = (Cat) animal;
                    cat.meow();
                }
                case "Dog" -> {
                    Dog dog = (Dog) animal;
                    dog.woof();
                }
                case "Cow" -> {
                    Cow cow = (Cow) animal;
                    cow.moo();
                }
            }
        }
    }
}

