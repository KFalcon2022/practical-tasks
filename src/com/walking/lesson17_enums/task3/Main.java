package com.walking.lesson17_enums.task3;

import com.walking.lesson17_enums.task3.equilateralshapes.EquilateralShape;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
		int shapeType = scanner.nextInt();
		
		scanner.close();

//        Корректнее валидировать значение сразу после ввода. Здесь проверка вынесена после
//        ради демонстрации ситуации, когда скобки в условном выражении действительно необходимы
		if (shapeType != 1 && shapeType != 2) {
			System.out.println("Incorrect input.");
			return;
		}
		
		String shapeString = createShapeString(shapeType);
		System.out.println(shapeString);
	}
	
	private static String createShapeString(int type) {
		EquilateralShape shape;
		
		switch (type) {
			case 1:
				shape = EquilateralShape.EQUILATERAL_SHAPE;
				break;
			case 2:
				shape = EquilateralShape.EQUILATERAL_TRIANGLE;
				break;
			default:
				return "Unknown shape";
		}
		
		return shape.createShapeString();
	}
	
}
