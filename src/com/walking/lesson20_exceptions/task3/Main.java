package com.walking.lesson20_exceptions.task3;

import com.walking.lesson18_instanceof_getClass.Task1.zoo.Animal;
import com.walking.lesson18_instanceof_getClass.Task1.zoo.Cat;
import com.walking.lesson18_instanceof_getClass.Task1.zoo.Cow;
import com.walking.lesson18_instanceof_getClass.Task1.zoo.Dog;
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
/**
 * Описание исходной задачи
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
 * Дополнительное условие (необязательно): решить задачу, при условии,
 * что woof(), meow() и moo() внутри себя выполняют только вызов protected-метода sound(),
 * который определен в Animal.
 */
public class Main {
    public static void main(String[] args) throws ArrayValidationException,UnknownAnimalException {
        Animal[] animals = new Animal[3];
        animals[0]=new Dog("Sharik");
        animals[1] = new Cat("Murka");
        animals[2]=new Cow("Burenka");
        soundAll(animals);
    }
    private static void soundAll(Animal[] animals) throws ArrayValidationException, UnknownAnimalException  {
        checkNullElement(animals);
        for (Animal animal : animals){
            if (animal instanceof Dog someDog)
                someDog.woof();
            else if (animal instanceof Cat someCat)
                someCat.meow();
            else if (animal instanceof Cow someCow)
                someCow.Moo();
            else throw new UnknownAnimalException("There is unknown animal");
        }
    }
    private static void checkNullElement(Animal[] animals) throws ArrayValidationException {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                throw new ArrayValidationException("The array contains empty element.", i);
            }
        }
    }
}
