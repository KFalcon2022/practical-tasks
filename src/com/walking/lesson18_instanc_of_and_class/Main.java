package com.walking.lesson18_instanc_of_and_class;

import com.walking.lesson18_instanc_of_and_class.model.Animal;
import com.walking.lesson18_instanc_of_and_class.model.Cat;
import com.walking.lesson18_instanc_of_and_class.model.Cow;
import com.walking.lesson18_instanc_of_and_class.model.Dog;

/**
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
 * <p>
 * Использовать при решении instanceof, getClass() или другие неизвестные нам механики – недопустимо.
 * <p>
 * Дополнительное условие (необязательно): решить задачу, при условии,
 * что woof(), meow() и moo() внутри себя выполняют только вызов protected-метода sound(),
 * который определен в Animal.
 */
public class Main {
	public static void main(String[] args) {
		Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow()};
		
		soundAll(animals);
	}
	
	private static void soundAll(Animal[] animals) {
		for (Animal animal : animals) {
			sound(animal);
		}
	}
	
	//    Используя поле класса Animal, определяем, какой настоящий класс обрабатываемого объекта
	private static void sound(Animal animal) {
		//На случай, если был создан объект Animal, а не наследника.
		if (Cat.class.equals(animal.getClass())) {
			((Cat) animal).meow();
		} else if (Dog.class.equals(animal.getClass())) {
			((Dog) animal).woof();
		} else if (Cow.class.equals(animal.getClass())) {
			((Cow) animal).moo();
		} else {// Или если наследник неизвестен
			System.out.println("Unknown animal!");
		}
	}
//	private static void sound(Animal animal) {
//		if (animal instanceof Cat cat) {
//			cat.meow();
//		} else if (animal instanceof Dog dog) {
//			dog.woof();
//		} else if (animal instanceof Cow cow) {
//			cow.moo();
//		} else {
//			System.out.println("Unknown animal!");
//		}
//	}
}

