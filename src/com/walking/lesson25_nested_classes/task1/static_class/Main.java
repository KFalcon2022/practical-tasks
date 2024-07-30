package com.walking.lesson25_nested_classes.task1.static_class;

import com.walking.lesson25_nested_classes.task1.static_class.model.EquilateralShape;
import com.walking.lesson25_nested_classes.task1.static_class.model.Shape;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя статические вложенные классы.
 */
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
        Shape shape = switch (selectedShape) {
            case 1 -> new EquilateralShape.Square(sideLength);
            case 2 -> new EquilateralShape.EquilateralTriangle(sideLength);
            default -> throw new RuntimeException("Invalid shape");
        };

        return shape.createShapeString();
    }
}
