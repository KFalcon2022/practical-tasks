package com.walking.lesson20_exceptions.task3;

/**
 * Реализуйте любой из вариантов задачи в уроке 18.
 * Для ситуации, когда тип животного неизвестен, выбрасывайте собственное исключение UnknownAnimalException.
 * Предка исключения определите самостоятельно.
 * <p>
 * Также предусмотрите валидацию массива животных на содержание пустых элементов.
 * Если таковые существуют – бросьте кастомное исключение ArrayValidationException,
 * которое содержит информацию об индексе массива, содержащем null.
 */

import com.walking.lesson20_exceptions.task3.model.*;
import com.walking.lesson20_exceptions.task3.exception.*;

public class Main {
    public static void main(String[] args) {
//        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow(), null };
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow(), new Chupakabra(), null };

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        try {
            for (int i=0; i<animals.length; i++){
                if (animals[i] == null){
                    throw new ArrayValidationException(i);
                } else sound(animals[i]);
            }
        } catch (ArrayValidationException arrayValidationException){
            System.out.println(arrayValidationException.getMessage()+":"+arrayValidationException.getIndex());
        } catch (UnknownAnimalException unknownAnimalException){
            System.out.println(unknownAnimalException.getMessage());
        }
    }

    private static void sound(Animal animal) throws UnknownAnimalException{
        if (animal instanceof Cat cat) {
            cat.meow();
        } else if (animal instanceof Dog dog) {
            dog.woof();
        } else if (animal instanceof Cow cow) {
            cow.moo();
        } else {
            throw new UnknownAnimalException("Unknown animal!");
        }
    }
}


