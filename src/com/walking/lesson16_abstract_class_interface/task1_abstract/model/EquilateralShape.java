package com.walking.lesson16_abstract_class_interface.task1_abstract.model;

public abstract class EquilateralShape {
	
	public static final String EMPTY_ELEMENT = " ";
	public static final String EMPTY_STRING = "";
	public static final char NEW_LINE_SYMBOL = '\n';
	
	protected final int length;
	
	protected EquilateralShape(int length) {
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
	
	abstract public String createShapeString();
}
