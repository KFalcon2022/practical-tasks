package com.walking.lesson25_nested_classes.task1.anonymous_class;

import com.walking.lesson25_nested_classes.task1.anonymous_class.model.InvalidInputException;
import com.walking.lesson25_nested_classes.task1.anonymous_class.model.IsEquilateralShape;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
    public static final String RECTANGLE_VERTICAL_ELEMENT = "|";
    public static final String TRIANGLE_SIDE_HORIZONTAL_ELEMENT = "--";
    public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
    public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's length: ");
        int length = scanner.nextInt();

        System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();

        scanner.close();

        if (length < 1) {
            scanner.close();
            throw new InvalidInputException("incorrect input shape's length ='" + length + "\'");
        } else if (shapeType != 1 && shapeType != 2) {
            scanner.close();
            throw new InvalidInputException("incorrect input shape's type ='" + shapeType + "\'");
        }

        String shapeString = createShapeString(length, shapeType);
        System.out.println(shapeString);
    }

    private static String createShapeString(int length, int type) {
        IsEquilateralShape shape;

        switch (type) {
            case 1:
                shape = createSquare(length);
                break;
            case 2:
                shape = createEquilateralTriangle(length);
                break;
            default:
                throw new InvalidInputException("Unknown shape");
        }

        return shape.createShapeString();
    }

    private static IsEquilateralShape createSquare(int length) {
        return new IsEquilateralShape() {

            @Override
            public int getLength() {
                return length;
            }

            @Override
            public String createShapeString() {
                String horizontalLine = createHorizontalLine(length);
                String verticalLines = createVerticalLine(length);

                return horizontalLine + verticalLines + horizontalLine;
            }

            private String createHorizontalLine(int length) {
                String horizontalLine = EMPTY_ELEMENT;

                for (int i = 0; i < length; i++) {
                    horizontalLine += RECTANGLE_HORIZONTAL_ELEMENT;
                }

                horizontalLine += EMPTY_ELEMENT + NEW_LINE_SYMBOL;

                return horizontalLine;
            }

            private String createVerticalLine(int length) {
                String verticalLinesUnit = getVerticalLinesUnit(length);

                String verticalLines = EMPTY_STRING;

                for (int i = 0; i < length; i++) {
                    verticalLines += verticalLinesUnit;
                }

                return verticalLines;
            }

            private String getVerticalLinesUnit(int length) {
                String verticalLinesUnit = RECTANGLE_VERTICAL_ELEMENT;

                for (int i = 0; i < length; i++) {
                    verticalLinesUnit += EMPTY_ELEMENT;
                }

                verticalLinesUnit += RECTANGLE_VERTICAL_ELEMENT + NEW_LINE_SYMBOL;

                return verticalLinesUnit;
            }
        };
    }

    public static IsEquilateralShape createEquilateralTriangle (int length) {
        return new IsEquilateralShape() {

            @Override
            public int getLength() {
                return length;
            }

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
                    triangle += TRIANGLE_SIDE_HORIZONTAL_ELEMENT;
                }

                return triangle;
            }
        };
    }
}