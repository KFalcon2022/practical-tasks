package com.walking.lesson25_nested_classes.task1.anonymous_class;

import com.walking.lesson25_nested_classes.task1.anonymous_class.model.EquilateralShape;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя анонимные классы.
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

    public static EquilateralShape createShape(int length, int type) {
        switch (type) {
            case SHAPE_SQUARE:
                return new EquilateralShape() {
                    public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
                    public static final String RECTANGLE_VERTICAL_ELEMENT = "|";

                    @Override
                    public String createShapeString() {
                        String horizontalLine = createHorizontalLine(length);
                        String verticalLines = createVerticalLines(length);

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

                    private String createVerticalLines(int length) {
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
            case SHAPE_EQUILATERAL_TRIANGLE:
                return new EquilateralShape() {
                    public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
                    public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
                    public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

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
                };
            default:
                throw new IllegalArgumentException("Unsupported shape type");
        }
    }
}