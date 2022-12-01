package com.walking.lesson18_getClass;
import com.walking.lesson18_getClass.model.*;

import java.lang.reflect.Array;
import java.util.Arrays;

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
        switch (animal.getClass().toString()) {

            case Cat.CAT_CLASS_NAME:
                    ((Cat) animal).meow();
//                    String s = animal.getClass().toString();
//                System.out.println(s);
//                String[] parts = s.split("\\.");
//                System.out.println(Arrays.toString(parts));
//                String lastOne = parts[parts.length-1];
//                System.out.println(lastOne);
                break;
            case Dog.DOG_CLASS_NAME:
                ((Dog) animal).woof();
                break;
            case Cow.COW_CLASS_NAME:
                ((Cow) animal).moo();
                break;
            default: //На случай, если был создан объект Animal, а не наследника.
                // Или если наследник неизвестен
                System.out.println("Unknown animal!");
        }
    }
}
