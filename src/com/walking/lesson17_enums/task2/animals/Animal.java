package com.walking.lesson17_enums.task2.animals;

public enum Animal {
	CAT("meow"), DOG("woof"), COW("moo");
	
	private final String sound;
	
	Animal(String sound) {
		this.sound = sound;
	}
	
	public void sound() {
		System.out.println(sound);
	}
}
