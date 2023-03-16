package com.walking.lesson20_exceptions.task3;

import com.walking.lesson18_instanceof_getClass.Task1.model.Animal;
import com.walking.lesson18_instanceof_getClass.Task1.model.Cat;
import com.walking.lesson18_instanceof_getClass.Task1.model.Cow;
import com.walking.lesson18_instanceof_getClass.Task1.model.Dog;

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

    public static void main(String[] args) throws UnknownAnimalException, ArrayValidationException {
        System.out.println("---lesson18_instanceof_getClass---");
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow(), null};

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) throws UnknownAnimalException, ArrayValidationException {
        for (int i = 0; i < animals.length;i++) {
            if (animals[i] == null){
                throw new ArrayValidationException(i);
            }
            sound(animals[i], 0);
            sound(animals[i], 2);
        }
    }

    //    Используя поле класса Animal, определяем, какой настоящий класс обрабатываемого объекта
    private static void sound(Animal animal, int method) throws UnknownAnimalException {
        //На случай, если был создан объект Animal, а не наследника.
        if (method == 0) {
            if (Cat.class.equals(animal.getClass())) {
                ((Cat) animal).meow();
            } else if (Dog.class.equals(animal.getClass())) {
                ((Dog) animal).woof();
            } else if (Cow.class.equals(animal.getClass())) {
                ((Cow) animal).moo();
            } else {// Или если наследник неизвестен
                throw new UnknownAnimalException("Unknown animal!");
            }
        } else {
            if (animal instanceof Cat){
                ((Cat) animal).meow();
            } else if (animal instanceof Dog) {
                ((Dog) animal).woof();
            } else if (animal instanceof Cow) {
                ((Cow) animal).moo();
            } else {// Или если наследник неизвестен
                throw new UnknownAnimalException("Unknown animal!");
            }
        }
    }

}
