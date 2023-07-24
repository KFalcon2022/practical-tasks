package com.walking.lesson20_exceptions.task3;

import com.walking.lesson20_exceptions.task3.exception.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.exception.UnknownAnimalException;
import com.walking.lesson20_exceptions.task3.model.*;

import java.util.Arrays;


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
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow(), null};
        for (Animal member : animals) {
            if (member == null) {
                throw new ArrayValidationException("Null in array index: %d".formatted(Arrays.asList(animals).indexOf(member)));
            }
        }

        try {
            soundAll(animals);
        } catch (UnknownAnimalException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void soundAll(Animal[] animals) throws UnknownAnimalException {
        for (Animal member : animals) {
            if (member instanceof Cat) {
                ((Cat) member).meow();
            } else if (member instanceof Dog) {
                ((Dog) member).woof();
            } else if (member instanceof Cow) {
                ((Cow) member).moo();
            } else {
                throw new UnknownAnimalException("Unknown animal");
            }
        }
    }
}

