package com.walking.lesson25_nested_classes.task1.inner_class;

// Реализуйте задачу https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface
// используя внутренние классы;

import com.walking.lesson25_nested_classes.task1.inner_class.model.EquilateralShape;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter side length: ");
        int sideLength = scanner.nextInt();

        if (sideLength < 1) {
            scanner.close();
            throw new RuntimeException("Side length must be greater than 0");
        }

        System.out.println("Select a shape:\n1. square\n2. triangle");
        int selectedShape = scanner.nextInt();

        scanner.close();

        String shapeString = createShapeString(sideLength, selectedShape);
        System.out.println(shapeString);
    }

    private static String createShapeString(int sideLength, int selectedShape) {
        EquilateralShape equilateralShape = new EquilateralShape();

        return switch (selectedShape) {
            case 1 -> equilateralShape.new Square(sideLength).createShape();
            case 2 -> equilateralShape.new EquilateralTriangle(sideLength).createShape();
            default -> throw new RuntimeException("Invalid shape");
        };
    }
}
