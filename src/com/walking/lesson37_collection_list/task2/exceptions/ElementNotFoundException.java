package com.walking.lesson37_collection_list.task2.exceptions;

public class ElementNotFoundException extends RuntimeException {
	public ElementNotFoundException() {
		super("Desired element not found");
	}
}