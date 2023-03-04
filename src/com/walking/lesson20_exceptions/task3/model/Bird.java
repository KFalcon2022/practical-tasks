package com.walking.lesson20_exceptions.task3.model;

public class Bird extends Animal{

	public static final String COW_CLASS_NAME = "Bird";

	public Bird() {
		super(COW_CLASS_NAME, "kurly-kurly");
	}

	public void kurly() {
		sound();
	}

}
