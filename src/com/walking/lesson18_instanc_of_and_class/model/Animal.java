package com.walking.lesson18_instanc_of_and_class.model;

public class Animal {
	
	//    Выполнение доп. условия. Если методы наследников лишь обращаются к sound() -
	//    нам необходимо делать вывод звука животного в этом классе. Значит, звук животного
	//    нужно куда-то записать
	private final String sound;
	
	protected Animal(String sound) {
		this.sound = sound;
	}
	
	protected void sound() {
		System.out.println(sound);
	}
	
}
