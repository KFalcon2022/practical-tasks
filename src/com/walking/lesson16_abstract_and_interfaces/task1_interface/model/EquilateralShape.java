package com.walking.lesson16_abstract_and_interfaces.task1_interface.model;

public interface EquilateralShape {
	
	String EMPTY_ELEMENT = " ";
	String EMPTY_STRING = "";
	char NEW_LINE_SYMBOL = '\n';
	
	int getLength();
	
	default String createShapeString() {
		return "Unknown shape";
	}
}
