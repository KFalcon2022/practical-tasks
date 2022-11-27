package com.walking.lesson13_inheritance.task2;

import com.walking.lesson13_inheritance.task2.model.Animal;
import com.walking.lesson13_inheritance.task2.model.Cat;
import com.walking.lesson13_inheritance.task2.model.Cow;
import com.walking.lesson13_inheritance.task2.model.Dog;

/**
 * Реализуйте класс Animal. Реализуйте его наследников: Dog, Cat, Cow.
 * Каждый из наследников должен содержать свой метод: woof(), meow() и moo() соответственно.
 * Остальные поля и методы суперкласса и наследников реализовать по своему усмотрению, если они необходимы.
 *
 * Каждый из методов должен выводить в консоль соответствующую ему строку: "woof ", "meow " или "moo".
 *
 * В main() создать и наполнить в произвольном порядке объектами разных классов-наследников массив типа Animal.
 * Реализовать метод, принимающий массив Animal и вызывающий метод, характерный для конкретного животного.
 *
 * Использовать при решении instanceof, getClass() или другие неизвестные нам механики – недопустимо.
 *
 * Дополнительное условие (необязательно): решить задачу, при условии, что woof(), meow() и moo()
 * внутри себя выполняют только вызов protected-метода sound(), который определен в Animal.
 */

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[10];
        animals[0] = new Dog("Бим", "dog");
        animals[1] = new Cow("Бурёнка", "cow");
        animals[2] = new Cow("Каролина", "cow");
        animals[3] = new Cat("Мурзик", "cat");
        animals[4] = new Dog("Мухтар", "dog");
        animals[5] = new Cat("Шерлок", "cat");
        animals[6] = new Cat("Пуша", "cat");
        animals[7] = new Dog("Лопоух", "dog");
        animals[8] = new Cow("Мумушка", "cow");
        animals[9] = new Cat("Рыжик", "cat");

        makeSound(animals);
    }

    public static void makeSound(Animal[] animals) {
        for (Animal animal : animals) {
            if (animal.type == "dog") {
                Dog castedDog = (Dog) animal;
                castedDog.woof();
            } else if (animal.type == "cat") {
                Cat castedCat = (Cat) animal;
                castedCat.meow();
            } else if (animal.type == "cow") {
                Cow castedCow = (Cow) animal;
                castedCow.moo();
            }
        }
    }
}
