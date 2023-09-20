package com.walking.lesson20_exceptions.task3;

import com.walking.lesson13_inheritance.task2.model.Animal;
import com.walking.lesson13_inheritance.task2.model.Cat;
import com.walking.lesson13_inheritance.task2.model.Cow;
import com.walking.lesson13_inheritance.task2.model.Dog;
import com.walking.lesson20_exceptions.task3.model.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.model.UnknownAnimalException;

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
    public static void main(String[] args) throws UnknownAnimalException {
        Animal[] animals = {new Cat(), new Dog(), null, new Cow(), new Dog()};

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) throws UnknownAnimalException, ArrayValidationException {
        int i = 0;
        for (Animal animal : animals) {
            if (animal == null) {
                throw new ArrayValidationException(i);
            }
            sound(animal);
            i++;
        }
    }

    private static void sound(Animal animal) throws UnknownAnimalException {

        if (!(animal instanceof Cat) && !(animal instanceof Dog) && !(animal instanceof Cow)) {
            throw new UnknownAnimalException("Не известное животное");
        }

        /*
        Здесь у меня не получилось использовать конструкцию
        if (animal instanceof Cat cat) {
            cat.meow();
        }
        т.к. идея ругается на уровень языка. Скорее всего это связано с версией идеи
        не ставлю новую, т.к. в этой продлеваю триальный период с помощью eval reset
         */

        if (animal instanceof Cat) {
            ((Cat) animal).meow();
        }
        if (animal instanceof Dog) {
            ((Dog) animal).woof();
        }
        if (animal instanceof Cow) {
            ((Cow) animal).moo();
        }

    }
}
