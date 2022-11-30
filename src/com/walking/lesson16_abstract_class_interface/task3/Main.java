package com.walking.lesson16_abstract_class_interface.task3;

import com.walking.lesson16_abstract_class_interface.task3.animals.Animal;
import com.walking.lesson16_abstract_class_interface.task3.animals.Cat;
import com.walking.lesson16_abstract_class_interface.task3.animals.Cow;
import com.walking.lesson16_abstract_class_interface.task3.animals.Dog;

public class Main {
	
	public static void main(String[] args) {
		
		Animal[] animals = {new Cat(), new Dog(), new Cow()};
		
		for (Animal animal : animals) {
			animal.sound();
		}
	}
}
