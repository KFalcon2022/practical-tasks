package com.walking.lesson28_generics1.task4.exceptions;

import java.io.FileNotFoundException;

public class ElementNotFoundException extends FileNotFoundException {
	public ElementNotFoundException (String message){
		super(message);
	}
}
