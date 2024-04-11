package com.walking.lesson20_exceptions.task3;

import com.walking.lesson18_instanceof_getClass.model.Animal;
import com.walking.lesson18_instanceof_getClass.model.Cat;
import com.walking.lesson18_instanceof_getClass.model.Cow;
import com.walking.lesson18_instanceof_getClass.model.Dog;
import com.walking.lesson20_exceptions.task3.exceptions.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.exceptions.UnknownAnimalException;

/**
 * Реализуйте любой из вариантов задачи в уроке 18.
 * Для ситуации, когда тип животного неизвестен, выбрасывайте собственное исключение UnknownAnimalException.
 * Предка исключения определите самостоятельно.
 * <p>
 * Также предусмотрите валидацию массива животных на содержание пустых элементов.
 * Если таковые существуют – бросьте кастомное исключение ArrayValidationException,
 * которое содержит информацию об индексе массива, содержащем null.
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
            if(animal == null) {
                throw new ArrayValidationException("Нет животного");
            }

            if (animal instanceof Cat cat) {
                cat.meow(animal);
            } else if (animal instanceof Dog dog) {
                dog.woof(animal);
            } else if (animal instanceof Cow cow) {
                cow.moo(animal);
            } else throw new UnknownAnimalException("Неизвестный тип животного");
        }
    }
}