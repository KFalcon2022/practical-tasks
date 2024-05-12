package com.walking.lesson25_nested_classes.task1.nested_class;

import com.walking.lesson25_nested_classes.task1.nested_class.model.InvalidInputException;
import com.walking.lesson25_nested_classes.task1.nested_class.model.EquilateralShape;
import com.walking.lesson25_nested_classes.task1.nested_class.model.IsEquilateralShape;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя внутренние классы.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's length: ");
        int length = scanner.nextInt();

        System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();

        scanner.close();

        if (length < 1) {
            throw new InvalidInputException("incorrect input shape's length ='" + length + "\'");
        } else if (shapeType != 1 && shapeType != 2) {
            throw new InvalidInputException("incorrect input shape's type ='" + shapeType + "\'");
        }

        String shapeString = createShapeString(length, shapeType);
        System.out.println(shapeString);
    }

    private static String createShapeString(int length, int type) {
        EquilateralShape shape = new EquilateralShape(length);
        IsEquilateralShape equilateralShape;

        switch (type) {
            case 1:
                equilateralShape = shape.new Square();
                break;
            case 2:
                equilateralShape = shape.new EquilateralTriangle();
                break;
            default:
                throw new InvalidInputException("Unknown shape");
        }

        return equilateralShape.createShapeString();
    }
}
