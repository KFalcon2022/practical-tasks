package com.walking.lesson18_instanceof_getClass.Task1;

import com.walking.lesson18_instanceof_getClass.Task1.model.Animal;
import com.walking.lesson18_instanceof_getClass.Task1.model.Cat;
import com.walking.lesson18_instanceof_getClass.Task1.model.Cow;
import com.walking.lesson18_instanceof_getClass.Task1.model.Dog;

/**
 * Реализуйте класс Animal.java. Реализуйте его наследников: Dog, Cat, Cow.
 * Каждый из наследников должен содержать свой метод: woof(), meow() и moo() соответственно.
 * Остальные поля и методы суперкласса и наследников реализовать по своему усмотрению,
 * если они необходимы.
 * <p>
 * Каждый из методов должен выводить в консоль соответствующую ему строку:
 * "woof ", "meow " или "moo".
 * <p>
 * В main() создать и наполнить в произвольном порядке
 * объектами разных классов-наследников массив типа Animal.java.
 * Реализовать метод, принимающий массив Animal.java и вызывающий метод,
 * характерный для конкретного животного.
 * <p>
 * Использовать при решении instanceof, getClass() или другие неизвестные нам механики – недопустимо.
 * <p>
 * Дополнительное условие (необязательно): решить задачу, при условии,
 * что woof(), meow() и moo() внутри себя выполняют только вызов protected-метода sound(),
 * который определен в Animal.java.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow()};
        soundAllInstanceOf(animals);
        soundAllGetClass(animals);
    }

    private static void soundAllInstanceOf(Animal[] animals) {
        for (Animal animal : animals) {
            if (animal instanceof Cat) {
                ((Cat) animal).meow();
            } else if (animal instanceof Dog) {
                ((Dog) animal).woof();
            } else if (animal instanceof Cow) {
                ((Cow) animal).moo();
            } else {
                System.out.println("Unknown");
            }
        }
    }

    private static void soundAllGetClass(Animal[] animals) {
        for (Animal animal : animals) {
            Class<?> typeObj = animal.getClass();
            if (typeObj.equals(Cat.class)) {
                ((Cat) animal).meow();
            } else if (typeObj.equals(Dog.class)) {
                ((Dog) animal).woof();
            } else if (typeObj.equals(Cow.class)) {
                ((Cow) animal).moo();
            } else {
                System.out.println("Unknown");
            }
        }
    }

    //    Используя поле класса Animal.java, определяем, какой настоящий класс обрабатываемого объекта

}