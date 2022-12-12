package com.walking.lesson25_nested_classes.task1.nested_class;

import com.walking.lesson25_nested_classes.task1.anonymous_class.exception.UnknownShapeException;
import com.walking.lesson25_nested_classes.task1.nested_class.model.EquilateralShape;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's length: ");
        int length = scanner.nextInt();

        System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();

        scanner.close();

        if (length < 1 || (shapeType != 1 && shapeType != 2)) {
            System.out.println("Incorrect input.");
            return;
        }

        String shapeString = createShapeString(length, shapeType);
        System.out.println(shapeString);
    }

    private static String createShapeString(int length, int type) {
        EquilateralShape shape = new EquilateralShape(length);
        EquilateralShape.Square square = shape.new Square();
        EquilateralShape.EquilateralTriangle triangle = shape.new EquilateralTriangle();

        switch (type) {
            case 1:
                return square.createShapeString();

            case 2:
                return triangle.createShapeString();
        }

        throw new UnknownShapeException("Unknown shape");
    }
}
