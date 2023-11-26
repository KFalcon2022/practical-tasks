package com.walking.lesson20_exceptions.task3.exceptions;

import com.walking.lesson20_exceptions.task3.model.Animal;

public class UnknownAnimalException extends Exception {


	public UnknownAnimalException(String message) {
		super(message);
	}

}
