package com.walking.lesson20_exeption.task3;

import com.walking.lesson20_exeption.task3.model.*;

/**
 * Реализовать задачу https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2
 * <p>
 * используя изученные способы проверки типа.
 * <p>
 * Вариант 1: используйте instanceof;
 * <p>
 * Вариант 2: используйте getClass().
 * <p>
 * Какой из способов больше подходит для данной задачи? Почему?
 */

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
    public static void main(String[] args) throws ArrayValidationException {
        Animal[] animals = new Animal[4];
        animals[0] = new Cat();
        animals[1] = new Dog();
        animals[2] = new Cow();

        //      soundAll(animals);
        try {
            for (int j = 0; j < animals.length; j++) {
                if (animals[j] == null) throw new ArrayValidationException("Пустое поле массива под номером:", j);
            }
        } catch (ArrayValidationException ex) {
            System.out.print(ex.getMessage());
            System.out.println(ex.getNumber());
        }

        try {
            for (int j = 0; j < animals.length; j++) {
                if (!animals[j].getClassName().equals("Cat")) throw new UnknownAnimalException("Неизвестное животное:", animals[j].getClassName());
            }
        } catch (UnknownAnimalException ex) {
            System.out.print(ex.getMessage());
            System.out.println(ex.getClassName());
        }

    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            sound(animal);
            soundInstanceOf(animal);
            soundGetClass(animal);
        }
    }

    //    Используя поле класса Animal, определяем, какой настоящий класс обрабатываемого объекта
    private static void sound(Animal animal) {
        switch (animal.getClassName()) {
            case Cat.CAT_CLASS_NAME:
                ((Cat) animal).meow();
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

    //используем instanceof
    private static void soundInstanceOf(Animal animal) {
        if (animal instanceof Cat animalCat) {
            animalCat.meow();
        } else if (animal instanceof Dog animalDog) {
            animalDog.woof();
        } else if (animal instanceof Cow animalCow) {
            animalCow.moo();
        } else {

            System.out.println("Conversion is invalid");
        }
    }

    //используя getClass
    private static void soundGetClass(Animal animal) {
        if (animal.getClass().equals(Cat.class)) {
            ((Cat) animal).meow();
        } else if (animal.getClass().equals(Dog.class)) {
            ((Dog) animal).woof();
        } else if (animal.getClass().equals(Cow.class)) {
            ((Cow) animal).moo();
        } else {

            System.out.println("Conversion is invalid");
        }
    }

}