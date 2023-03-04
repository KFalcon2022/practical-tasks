package com.walking.lesson20_exceptions.task3.exceptions;

public class ArrayValidationException extends Exception{
	int index;
	public ArrayValidationException(String message, int index) {
		super(message);
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
