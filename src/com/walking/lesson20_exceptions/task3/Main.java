package com.walking.lesson20_exceptions.task3;

import com.walking.lesson20_exceptions.task3.exception.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.exception.UnknownAnimalException;
import com.walking.lesson20_exceptions.task3.model.*;

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
        Animal[] animals = initAnimals();
        soundAnimal(animals);
    }

    private static Animal[] initAnimals() {
        Animal[] animals = new Animal[]{new Dog(), new Cat(), new Cow(), null, new Bird()};

        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                throw new ArrayValidationException("Массив животных содержит \"null\" индекс: " + i);
            }
        }

        return animals;
    }

    private static void soundAnimal(Animal[] animals) {
        try {
            for (Animal animal : animals) {
                sound(animal);
            }

        } catch (UnknownAnimalException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void sound(Animal animal) {
        switch (animal) {
            case Cat cat -> cat.meow();
            case Dog dog -> dog.woof();
            case Cow cow -> cow.moo();
            default -> throw new UnknownAnimalException("Вид животного неизвестен.");
        }
    }
}
