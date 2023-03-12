package com.walking.lesson28_generics1.task3.exceptions;

import java.io.FileNotFoundException;

public class ValueNotFoundException extends FileNotFoundException {
	public ValueNotFoundException(String message) {
		super(message);
	}

}
