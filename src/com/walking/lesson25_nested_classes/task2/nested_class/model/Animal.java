package com.walking.lesson25_nested_classes.task2.nested_class.model;

public class Animal {

	public Animal() {}

	public void sound() {
		System.out.println("Unknown animal!");
	}

	public class Cat{
		public void sound() {
			System.out.println("meow");
		}
	}

	public class Cow{
		public void sound() {
			System.out.println("moo");
		}
	}

	public class Dog {
		public void sound() {
			System.out.println("woof");
		}
	}
}