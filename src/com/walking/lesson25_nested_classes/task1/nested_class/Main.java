package com.walking.lesson25_nested_classes.task1.nested_class;


import com.walking.lesson25_nested_classes.task1.nested_class.model.EquilateralShape;
import com.walking.lesson25_nested_classes.task1.nested_class.model.Shape;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя внутренние классы.
 */
public class Main {
    public static final int LENGTH_MIN = 1;
    public static final int LENGTH_MAX = 10;
    public static final int SHAPE_SQUARE = 1;
    public static final int SHAPE_EQUILATERAL_TRIANGLE = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter shape's length: ");
        int length = scanner.nextInt();
        validateLength(length);

        System.out.printf("Enter shape's type:\n %d: Square\n %d: Triangle\n%n", SHAPE_SQUARE, SHAPE_EQUILATERAL_TRIANGLE);
        int shapeType = scanner.nextInt();
        scanner.close();
        validateShape(shapeType);

        EquilateralShape shape = createShape(length, shapeType);
        System.out.println(shape.createShapeString());
    }

    private static void validateLength(int length) {
        if (length < LENGTH_MIN || length > LENGTH_MAX) {
            throw new IllegalArgumentException(String.format("Length has constraints [%d, %d]", LENGTH_MIN, LENGTH_MAX));
        }
    }

    private static void validateShape(int type) {
        if (type != SHAPE_SQUARE && type != SHAPE_EQUILATERAL_TRIANGLE) {
            throw new IllegalArgumentException("Unsupported shape type");
        }
    }

    private static EquilateralShape createShape(int length, int type) {
        Shape shape = new Shape(length);

        switch (type) {
            case SHAPE_SQUARE:
                return shape.new Square();
            case SHAPE_EQUILATERAL_TRIANGLE:
                return shape.new EquilateralTriangle();
            default:
                throw new IllegalArgumentException("Unsupported shape type");
        }
    }
}
