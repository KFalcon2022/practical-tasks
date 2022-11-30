package com.walking.lesson17_enums.task2;

import com.walking.lesson17_enums.task2.animals.Animal;

public class Main {
	public static void main(String[] args) {
		Animal[] animals = new Animal[]{Animal.CAT, Animal.DOG, Animal.COW};
		
		soundAll(animals);
	}
	
	private static void soundAll(Animal[] animals) {
		for (Animal animal : animals) {
			animal.sound();
		}
	}
}
