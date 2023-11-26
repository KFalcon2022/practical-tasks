package com.walking.lesson25_nested_classes.task2.anonymous_class;

import com.walking.lesson25_nested_classes.task2.exceptions.UnknownShapeException;

import javax.lang.model.element.UnknownElementException;
import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's length: ");
        int length = scanner.nextInt();

        System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();

        scanner.close();

        if (length < 1 || (shapeType != 1 && shapeType != 2)) {
            throw new IllegalArgumentException("Incorrect input.");
        }

        try {
            String shapeString = createShapeString(length, shapeType);
            System.out.println(shapeString);
        } catch (UnknownShapeException e) {
            System.out.println(e.getMessage());
        }

    }

    private static String createShapeString(int length, int type) throws UnknownShapeException {

        final int finalLength = length;
        EquilateralShape shape;

        switch (type) {
            case 1:
                shape = new EquilateralShape() {

                    public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
                    public static final String RECTANGLE_VERTICAL_ELEMENT = "|";

                    private final int length = finalLength;

                    @Override
                    public int getLength() {
                        return length;
                    }

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
                break;
            case 2:
                shape = new EquilateralShape() {

                    public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
                    public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
                    public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

                    private int length = finalLength;

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
                            triangle += TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
                        }

                        return triangle;
                    }
                };
                break;
            default:
                throw new UnknownShapeException("Unknown Shape");
        }

        return shape.createShapeString();
    }

    public interface EquilateralShape {
        String EMPTY_ELEMENT = " ";
        String EMPTY_STRING = "";
        char NEW_LINE_SYMBOL = '\n';

        int getLength();

        String createShapeString();
    }
}
