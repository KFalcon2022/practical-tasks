package com.walking.lesson18_instanc_of_and_class.model;

public class Cat extends Animal {
	
	//    Передаем параметры в super внутри конструктора, а не принимая их в параметры Cat(),
	//    чтобы избежать ошибочного поведения при использовании этого класса
	public Cat() {
		super("meow");
	}
	
	public void meow() {
		sound();
	}
}
