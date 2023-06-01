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
        Cat cat = new Cat("Cat");
        Dog dog = new Dog("Dog");
        Cow cow = new Cow("Cow");

        Animal[] animals = new Animal[]{cat, dog, cow};

        makeSound(animals);
    }

    public static void makeSound(Animal[] animals) {
        for (Animal member : animals) {
            switch (member.getClassName()) {
                case "Cat" -> ((Cat) member).meow();
                case "Dog" -> ((Dog) member).woof();
                case "Cow" -> ((Cow) member).moo();
                default -> System.out.println("Unknown animal");
            }
        }
    }
}
