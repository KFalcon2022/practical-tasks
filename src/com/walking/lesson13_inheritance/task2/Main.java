package com.walking.lesson13_inheritance.task2;

import com.walking.lesson13_inheritance.task2.animal.Animal;
import com.walking.lesson13_inheritance.task2.animal.Cat;
import com.walking.lesson13_inheritance.task2.animal.Cow;
import com.walking.lesson13_inheritance.task2.animal.Dog;

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
        Animal[] animals = new Animal[]{new Dog(), new Cat(), new Cow()};

        System.out.println(call(animals));
    }

    private static String call(Animal[] animals) {
        String all = "";
        for (Animal x : animals) {
            all += x.sound() + "\n";
        }
        return all;
    }
}
