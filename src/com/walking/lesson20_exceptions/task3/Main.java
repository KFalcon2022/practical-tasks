package com.walking.lesson20_exceptions.task3;

import com.walking.lesson20_exceptions.task2.exceptions.InputValidationException;
import com.walking.lesson20_exceptions.task3.exceptions.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.exceptions.UnknownAnimalException;
import com.walking.lesson20_exceptions.task3.model.*;

/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя getClass().
 */
public class Main {
	public static void main(String[] args) {
		Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow(), new Bird(), null};
		try {
			soundAll(animals);
		}catch (ArrayValidationException e){
			System.err.println(e.getMessage() + " " + e.getIndex());
		}

	}

	private static void soundAll(Animal[] animals) throws ArrayValidationException{
		try {
			for (int i = 0; i < animals.length; i++) {
				if (animals[i] == null){
					throw new ArrayValidationException("Null value in array!", i);
				}
				sound(animals[i]);
			}
		}catch (UnknownAnimalException e){
			System.err.println(e.getMessage());
		}
	}

	//    Используя поле класса Animal, определяем, какой настоящий класс обрабатываемого объекта
	private static void sound(Animal animal) throws UnknownAnimalException {
		if (animal.getClass().equals(Dog.class)) {
			((Dog) animal).woof();
		} else if (animal.getClass().equals(Cat.class)) {
			((Cat) animal).meow();
		} else if (animal.getClass().equals(Cow.class)) {
			((Cow) animal).moo();
		}else {
			throw new UnknownAnimalException("Unknown animal!");
		}
	}
}