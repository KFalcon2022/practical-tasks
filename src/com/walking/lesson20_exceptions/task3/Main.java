package com.walking.lesson20_exceptions.task3;


import com.walking.lesson20_exceptions.task3.Exceptions.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.Exceptions.UnknownAnimalException;

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
    public static void main(String[] args)  {
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow(), new Animal("sdf")};
        soundALl(animals);

    }

    public static void soundALl(Animal[] animals) throws ArrayValidationException {

            for (int i = 0; i < animals.length; i++) {

                if (animals[i] == null) {
                    throw new ArrayValidationException(i);
                }
                if (animals[i].getClass().equals(Cat.class)) {
                    ((Cat) animals[i]).meow();
                } else if (animals[i].getClass().equals(Dog.class)) {
                    ((Dog) animals[i]).woof();
                } else if (animals[i].getClass().equals(Cow.class)) {
                    ((Cow) animals[i]).moo();
                } else throw new UnknownAnimalException("Unknown animal!");
            }

    }
}
