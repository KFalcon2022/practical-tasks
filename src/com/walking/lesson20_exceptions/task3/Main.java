package com.walking.lesson20_exceptions.task3;

import com.walking.lesson20_exceptions.task3.exeptions.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.exeptions.UnknownAnimalException;
import com.walking.lesson20_exceptions.task3.model.Animal;
import com.walking.lesson20_exceptions.task3.model.Cat;
import com.walking.lesson20_exceptions.task3.model.Cow;
import com.walking.lesson20_exceptions.task3.model.Dog;

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
        Animal[] animals = {new Cat(), new Dog(), new Cow()};
        try {
            soundAll(animals);
        }
        catch (ArrayValidationException ex) {
            System.out.printf("%d %s", ex.getIndex(), ex.getMessage());
        }
    }

    private static void soundAll (Animal[] animals) throws UnknownAnimalException {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                throw new ArrayValidationException("item in array is null", i);
            }
            if (Cat.class.equals(animals[i].getClass())) {
               ((Cat) animals[i]).meow();
            } else if (Cow.class.equals(animals[i].getClass())) {
               ((Cow) animals[i]).moo();
            } else if (Dog.class.equals(animals[i].getClass())) {
               ((Dog) animals[i]).woof();
            } else {
               throw new UnknownAnimalException("Unknown animal");
            }
        }
    }
}
