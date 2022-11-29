package com.walking.lesson16_abstract_and_interfaces.task1_interface.model;


public class EquilateralTriangle implements EquilateralShape {
	
	//    За единицу у основания принято "--" для минимально удобоваримой визуализации
	public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
	public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
	public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";
	private final int length;
	
	
	public EquilateralTriangle(int length) {
		this.length = length;
	}
	
	//    Предлагаю особо не углубляться в способ отрисовки, он не критичен - задача направлена на
//    овладевание переопределением, а не псевдографикой
	@Override
	public String createShapeString() {
		String triangle = EMPTY_STRING;
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - i; j++) {
				triangle += EMPTY_ELEMENT;
			}
			
			triangle += TRIANGLE_LEFT_SIDE_ELEMENT;
			
			for (int j = 0; j < i * 2; j++) {
				triangle += EMPTY_ELEMENT;
			}
			
			triangle += TRIANGLE_RIGHT_SIDE_ELEMENT + NEW_LINE_SYMBOL;
		}
		
		triangle += " ";
		
		for (int i = 0; i < length; i++) {
			triangle += TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
		}
		
		return triangle;
	}
	
	@Override
	public int getLength() {
		return length;
	}
}
